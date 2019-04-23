package com.jt.sys.service;
import java.util.List;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysRole;
import com.jt.sys.vo.SysRoleVo;

public interface SysRoleService {
	/**
	 * 查询所有角色信息
	 * @return
	 */
	List<CheckBox> findObjects();
	
	/**
	 * 基于角色id查询角色自身信息以及角色关联的
	 * 菜单信息
	 * @param id
	 * @return
	 */
	SysRoleVo findObjectById(Integer id);
	
	/**
	 * 更新角色以及角色和菜单的关系数据
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	int updateObject(SysRole entity,
			Integer[] menuIds);
	 /**
	  * 保存角色以及角色和菜单的关系数据
	  * @param entity
	  * @param menuIds
	  * @return
	  */
	 int saveObject(SysRole entity,
			 Integer[] menuIds);
	
	 /**
	  * 基于角色id删除
	  * 1)角色自身信息
	  * 2)角色菜单关系数据
	  * 3)角色与用户关系数据
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
     /**
      * 查询当前页记录以及总记录数并对其进行封装
      * @param username  查询条件"用户名"
      * @param pageCurrent 当前页的页码
      * @return
      */
	 PageObject<SysRole> findPageObjects(
			 String name,
			 Integer pageCurrent);
	 
	 
}



