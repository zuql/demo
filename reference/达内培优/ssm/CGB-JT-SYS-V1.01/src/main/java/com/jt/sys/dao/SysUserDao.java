package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysUser;
import com.jt.sys.vo.SysUserDeptResult;

public interface SysUserDao {
	/**
	 * 基于用户名查找用户对象
	 * @param username
	 * @return
	 */
	SysUser findUserByUserName(String username);
	/**
	 * 更新用户自身信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity);
	/**
	 * 基于用户id查询用户以及用户对应的部门信息
	 * @param id
	 * @return
	 */
	SysUserDeptResult findObjectById(Integer id);
	
	/**
	 * 保存用户自身信息
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);
	
	/**
	 * 禁用启用用户对象
	 * @param id  用户id
	 * @param valid 用户状态(0,1)
	 * @param modifiedUser 修改用户
	 * @return
	 */
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);

    /**
     * 查询当前页要显示的记录
     * @param username 查询条件
     * @param startIndex 当前页的起始位置
     * @param pageSize 页面大小(每页最多显示多少条记录)
     * @return
     */
	List<SysUserDeptResult> findPageObjects(
			@Param("username") String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 依据查询条件获取总记录数(后续通过此值计算总页数)
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("username") String username);
	
	
	
	
	

}
