package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.CheckBox;
import com.jt.sys.entity.SysRole;
import com.jt.sys.vo.SysRoleVo;

public interface SysRoleDao {
	/**
	 * 查询所有角色信息(只包含id和name)
	 * @return
	 */
	List<CheckBox> findObjects();
	
	/**
	 * 更新角色自身信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysRole entity);
	/**
	 * 基于id查询角色以及角色对应的菜单信息
	 * @param id
	 * @return
	 */
	SysRoleVo findObjectById(Integer id);
	/**
	 * 插入角色自身信息
	 * @param entity
	 * @return
	 */
	int insertObject(SysRole entity);
	/**
	 * 基于角色id删除角色自身信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
    /**
     * 分页查询角色信息
     * @param startIndex 上一页的结束位置
     * @param pageSize 每页要查询的记录数
     * @return
     */
	List<SysRole> findPageObjects(
            @Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 查询记录总数
	 * @return
	 */
	int getRowCount(@Param("name")String name);

}
