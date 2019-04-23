package com.jt.common.vo;
import java.io.Serializable;
/**
 * VO:封装只有id和name的checkbox对象,
 * 例如用户角色的选择
 * @author Administrator
 */

public class CheckBox implements Serializable{
	private static final long serialVersionUID = -412637841166383222L;
	private Integer id;
	private String name;
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
	
}
