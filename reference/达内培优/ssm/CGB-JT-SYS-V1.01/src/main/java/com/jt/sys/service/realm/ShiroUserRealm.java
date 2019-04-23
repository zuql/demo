package com.jt.sys.service.realm;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysUser;

@Service
public class ShiroUserRealm extends AuthorizingRealm {
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Autowired
	private SysMenuDao sysMenuDao;
	
	/**
	 * 设置登录时使用的凭证匹配器
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		//1.构建凭证匹配器对象
		HashedCredentialsMatcher hcm=
	    new HashedCredentialsMatcher("MD5");
		//2.设置加密次数(例如1次)
		hcm.setHashIterations(1);
		super.setCredentialsMatcher(hcm);
	}
	/**在此方法完成用户信息的获取以及封装*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	    //1.从参数token中获取用户信息
		UsernamePasswordToken upToken=
		(UsernamePasswordToken)token;
		String username=upToken.getUsername();
		//2.基于用户名从数据库查找用户信息
		SysUser user=sysUserDao.findUserByUserName(username);
		//3.验证用户是否存在
		if(user==null)
		throw new UnknownAccountException();
		//throw new AuthenticationException();
		//4.验证用户是否已被禁用
		if(user.getValid()==0)
		throw new LockedAccountException();
		//5.封装用户信息(包含密码等)
		//5.1处理盐值数据,封装为ByteSource对象
		ByteSource credentialsSalt=
		ByteSource.Util.bytes(user.getSalt());
		//5.2封装用户信息(来自数据库)
		SimpleAuthenticationInfo info=
		new SimpleAuthenticationInfo(
				user, //principal 用户身份
				user.getPassword(),// hashedCredentials 已加密的密码
				credentialsSalt,//credentialsSalt
				getName());//realmName
		return info;//此值会返回给认证管理器
	}
	private Map<String,SimpleAuthorizationInfo> pCache=
			new ConcurrentHashMap<>();//JUC
	/**在此方法中完成用户权限信息的获取以及封装*/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
	    //1.获取当前用户
		SysUser user=(SysUser)principals.getPrimaryPrincipal();//主身份
		if(pCache.containsKey(user.getUsername())){
			return pCache.get(user.getUsername());
		}
		System.out.println("doGetAuthorizationInfo");
		//2.获取用户拥有角色信息(基于用户id获取角色id):sys_user_roles
		List<Integer> roleIds=
		sysUserRoleDao.findRoleIdsByUserId(user.getId());
		if(roleIds==null||roleIds.size()==0)
		throw new UnauthorizedException();
		//3.获取这些角色对应菜单(资源,基于角色id查菜单id):sys_role_menus
		List<Integer> menuIds=
		sysRoleMenuDao.findMenuIdsByRoleIds(
			roleIds.toArray(new Integer[]{}));
		if(menuIds==null||menuIds.size()==0)
		throw new UnauthorizedException();
		//4.获取菜单id对应的权限标识(sys:user:update,sys:user:valid):sys_menus
		List<String> permissions=
		sysMenuDao.findPermissions(
		menuIds.toArray(new Integer[]{}));
		if(permissions==null||permissions.size()==0)
	    throw new UnauthorizedException();
		//5.封装权限信息,并返回
		SimpleAuthorizationInfo info=
		new SimpleAuthorizationInfo();
		Set<String> set=new HashSet<>();
		System.out.println("permissions="+permissions);
		for(String per:permissions){
			if(!StringUtils.isEmpty(per)){
				set.add(per);
			}
		}
		info.setStringPermissions(set);
		pCache.put(user.getUsername(),info);
		return info;//返回给授权管理器
	}
}










