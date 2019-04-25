package com.jt.common.utils;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Container {
	
	private List<String> list;
	private Map<String,Object> map;
	private Properties props;
	
	public Container() {
		System.out.println("Container()");
	}
	
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	
	

}
