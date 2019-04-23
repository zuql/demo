package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 角色菜单关系表对应的数据
 * @author Administrator
 */
public interface SysRoleMenuDao {
	/**
	 * 基于角色id查找菜单id
	 * @param roleIds
	 * @return
	 */
	List<Integer> findMenuIdsByRoleIds(
	@Param("roleIds")Integer[] roleIds);

	/**
	 * 插入角色和菜单的关系数据
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	int insertObject(
		@Param("roleId")Integer roleId,
		@Param("menuIds")Integer[] menuIds);

	/**
	 * 基于角色id删除角色和菜单的关系数据
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer roleId);
	/**
	 * 基于菜单id删除菜单和角色的关系数据
	 * @param menuId
	 * @return
	 */
	int deleteObjectsByMenuId(Integer menuId);
}
