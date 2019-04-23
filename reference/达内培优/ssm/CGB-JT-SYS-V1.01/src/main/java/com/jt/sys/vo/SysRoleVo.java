package com.jt.sys.vo;

import java.io.Serializable;
import java.util.List;
/**
 * 定义值对象(VO):借助此对象封装角色修改时
 * 从数据库获取的角色以及角色相关的菜单id信息
 * @author Administrator
 */
public class SysRoleVo implements Serializable{
	private static final long serialVersionUID = -48491083382607667L;
	/**角色id*/
	private Integer id;
	/**角色名称*/
	private String name;
	/**角色备注*/
	private String note;
	/**菜单id*/
	private List<Integer> menuIds;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
	
}
