package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 用于操作用户和角色的关系表
 * @author Administrator
 */
public interface SysUserRoleDao {
	
	
	/**基于用户id删除用户和角色的关系数据*/
	int deleteObjectsByUserId(Integer userId);
	/**
	 * 基于用户id查询用户对应的角色id
	 * @param userId
	 * @return
	 */
	List<Integer> findRoleIdsByUserId(Integer userId);
	
	/**
	 * 保存用户和角色关系数据
	 * @param userId  用户id
	 * @param roleIds 用户对应的角色id
	 * @return
	 */
	int insertObject(
			@Param("userId")Integer userId,
			@Param("roleIds")Integer[]roleIds);
	
	/**
	 * 基于角色id删除角色和用户的关系数据
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer roleId);
}
