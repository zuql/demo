package com.jt.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.anno.RequiresLog;
import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysLog;
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.SysUserService;
import com.jt.sys.vo.SysUserDeptResult;
/**业务层对象
 * @Service 注解对于spring底层矿建而言与@Controller注解
 * 的待遇一样的(Spring都会将其看成是由它管理的Bean对象).
 * */
@Service //<bean id="" class="">
public class SysUserServiceImpl implements SysUserService {
    //DI (SPRING)
	//告诉spring帮我找这个类型的对象,然后给我注入
	@Autowired
	//@Qualifier("sysLogDaoImpl")//按名字"sysLogDaoImpl"从容器找对象,然后进行DI
	private SysUserDao sysUserDao;//ref 
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	
	@Override
	public Map<String, Object> findObjectById(
			Integer userId) {
		//1.参数校验
		if(userId==null||userId<1)
		throw new IllegalArgumentException("参数值无效");
		//2.查询用户以及用户所属的部门信息
		SysUserDeptResult result=
		sysUserDao.findObjectById(userId);
		if(result==null)
		throw new ServiceException("此记录可能已经不存在");
		//3.查询用户对应的角色id
		List<Integer> roleIds=
		sysUserRoleDao.findRoleIdsByUserId(userId);
		//4.封装查询结果并返回
		Map<String,Object> map=new HashMap<>();
		map.put("user", result);
		map.put("roleIds", roleIds);
		return map;
	}
	@RequiresLog("修改用户")
	@Override
	public int updateObject(SysUser entity, Integer[] roleIds) {
		//1.参数的有效验证
		if(entity==null)
		throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUsername().trim()))
	    throw new IllegalArgumentException("用户名不能为空");
		//...
		//2.更新用户自身信息
		int rows=sysUserDao.updateObject(entity);
		//3.保存用户角色关系数据
		sysUserRoleDao.deleteObjectsByUserId(entity.getId());
		sysUserRoleDao.insertObject(entity.getId(),
				roleIds);
		//4.返回结果
		return rows;
	}
	@Override
	public int saveObject(SysUser entity, Integer[] roleIds) {
		//1.参数的有效验证
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUsername().trim()))
			throw new IllegalArgumentException("用户名不能为空");
		if(StringUtils.isEmpty(entity.getPassword().trim()))
			throw new IllegalArgumentException("密码不能为空");
		//...
		//2.保存用户自身信息
		//2.1获取一个盐值对象(借助随机字符串)
		String salt=UUID.randomUUID().toString();
		entity.setSalt(salt);
		//2.2对密码进行加密
		SimpleHash sh=new SimpleHash(//Shiro
				"MD5",//加密算法
				entity.getPassword(),
				salt,
				1);
		String newPassword=sh.toHex();
		entity.setPassword(newPassword);
		//2.3用户信息持久化
		int rows=sysUserDao.insertObject(entity);
		//3.保存用户角色关系数据
		sysUserRoleDao.insertObject(entity.getId(),
				roleIds);
		//4.返回结果
		return rows;
	}
	/**
	 * 项目中需要授权访问的方法需要添加
	 * @RequiresPermissions注解,并且
	 * 指定访问此方法需要的权限.当用户
	 * 拥有这些权限时便可授权访问.
	 * 
	 * 系统底层原理:
	 * 底层会通过Subject.isPermitted("sys:user:valid")
	 * 提交给授权管理器,授权管理器就会
	 * 检测认证用户是否拥有此权限.
	 */
	@RequiresPermissions("sys:user:valid")
	@RequiresLog("禁用启用")
	@Override
	public int validById(Integer id, Integer valid, String modifiedUser) {
		long startTime=System.currentTimeMillis();
		//1.检测参数有效性
		if(id==null||id<1)
	    throw new IllegalArgumentException("id值无效");
		if(valid!=0&&valid!=1)
		throw new IllegalArgumentException("状态值不正确");
		//2.执行禁用启用操作
		int rows=sysUserDao.validById(id, valid, modifiedUser);
		//3.验证并返回结果
		if(rows==0)
		throw new ServiceException("记录可能已经不存在");
		long endTime=System.currentTimeMillis();
		long totalTime=endTime-startTime;
		System.out.println("totalTime="+totalTime);
		return rows;
	}
	@Override
	public PageObject<SysUserDeptResult> findPageObjects(
			String username, 
			Integer pageCurrent) {
		//1.判定pageCurrent参数的合法性
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确");
		//2.基于用户名统计日志记录总数
		int rowCount=sysUserDao.getRowCount(username);
		//3.对日志记录总数进行验证(总数为0就没有必要继续查询了)
		if(rowCount==0)
		throw new ServiceException("记录不存在");
		//4.查询当前页要显示的记录
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUserDeptResult> records=
		sysUserDao.findPageObjects(username, 
				startIndex, pageSize);//limit startIndex,pageSize
		//5.对象查询的记录,总记录数以及相关分页信息进行封装.
		PageObject<SysUserDeptResult> po=new PageObject<>();
		po.setRecords(records);
		po.setRowCount(rowCount);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		
		//int pageCount=rowCount/pageSize;
		//if(rowCount%pageSize!=0)pageCount++;
		int pageCount=(rowCount-1)/pageSize+1;
		po.setPageCount(pageCount);//总页数
		//6.返回结果
		
		
		return po;
	}

}






