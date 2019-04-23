package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jt.common.anno.DataFilter;
import com.jt.common.exception.ServiceException;
import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysRole;
import com.jt.sys.service.SysRoleService;
import com.jt.sys.vo.SysRoleVo;
/**业务层对象
 * @Service 注解对于spring底层矿建而言与@Controller注解
 * 的待遇一样的(Spring都会将其看成是由它管理的Bean对象).
 * */
@Service //<bean id="" class="">
@Transactional(rollbackFor=Throwable.class,timeout=30,
               propagation=Propagation.REQUIRED)
public class SysRoleServiceImpl implements SysRoleService {
    //DI (SPRING)
	//告诉spring帮我找这个类型的对象,然后给我注入
	@Autowired
	private SysRoleDao sysRoleDao;//ref 
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	//@Transactional注解中的readOnly默认false
	@Transactional(readOnly=true)//只读事务,性能相对于写会高出很多
	@Override
	public List<CheckBox> findObjects() {
		return sysRoleDao.findObjects();
	}
	
	@Override
	public SysRoleVo findObjectById(Integer id) {
		if(id==null||id<1)
		throw new IllegalArgumentException("id值不正确");
		SysRoleVo srVo=sysRoleDao.findObjectById(id);
		if(srVo==null)
		throw new ServiceException("此记录可能已经不存在");
		return srVo;
	}
	
	@Override
	public int updateObject(SysRole entity, 
			Integer[] menuIds) {
		
		//1.参数合法性校验
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("角色名不能为空");
		if(menuIds==null||menuIds.length==0)
			throw new IllegalArgumentException("必须为角色分配权限");
		//2.保存角色自身信息
		int rows=sysRoleDao.updateObject(entity);
		//3.保存角色和菜单的关系数据
		//3.1先删除关系数据
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		//3.2再保存关系数据
		sysRoleMenuDao.insertObject(entity.getId(),
				menuIds);
		//4.返回结果
		return rows;
	}

	@Override
	public int saveObject(SysRole entity, 
			Integer[] menuIds) {
		//1.参数合法性校验
		if(entity==null)
		throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
		throw new IllegalArgumentException("角色名不能为空");
		if(menuIds==null||menuIds.length==0)
		throw new IllegalArgumentException("必须为角色分配权限");
		//2.保存角色自身信息
		int rows=sysRoleDao.insertObject(entity);
		//3.保存角色和菜单的关系数据
		int menuRows=sysRoleMenuDao.insertObject(entity.getId(),
				menuIds);
		//if(menuRows>0)
		//throw new ServiceException("关系数据写入失败");	
		//4.返回结果
		return rows;
	}
	
	@DataFilter
	@Override
	public int deleteObject(Integer id) {
		//1.参数有效性验证
		if(id==null||id<1)
		throw new IllegalArgumentException("ID值不能为空");
		//2.删除角色自身信息
		int rows=sysRoleDao.deleteObject(id);
		if(rows==0)
		throw new ServiceException("记录可能已经不存在");
		//3.删除角色菜单关系数据
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		//4.删除角色用户关系数据
		sysUserRoleDao.deleteObjectsByRoleId(id);
		//5.返回结果
		return rows;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public PageObject<SysRole> findPageObjects(
			String name, 
			Integer pageCurrent) {
		//1.判定pageCurrent参数的合法性
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确");
		//2.基于用户名统计日志记录总数
		int rowCount=sysRoleDao.getRowCount(name);
		//3.对日志记录总数进行验证(总数为0就没有必要继续查询了)
		if(rowCount==0)
		throw new ServiceException("记录不存在");
		//4.查询当前页要显示的记录
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> records=
		sysRoleDao.findPageObjects(name, 
				startIndex, pageSize);//limit startIndex,pageSize
		//5.对象查询的记录,总记录数以及相关分页信息进行封装.
		PageObject<SysRole> po=new PageObject<>();
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






