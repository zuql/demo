package com.jt.common.utils;
/**
 * 如何将此对象交给Spring管理？
 * 1)以xml的方式对此对象进行描述(在配置文件中以<bean>进行描述)
 * 2)以注解的方式对此对象进行描述
 */
public class OpenDataSource {//javax.sql.DataSource
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private Integer maxActive;//最大活动连接数
	private Integer maxIdle;//连接的最da空闲时间
	public OpenDataSource(){
		System.out.println("OpenDataSource()");
	}
	private OpenDataSource(int maxActive,int maxIdle) {
		System.out.println("OpenDataSource(int coreSize,int maxSize)");
	    this.maxActive=maxActive;
	    this.maxIdle=maxIdle;
	}
	public void init(){
		System.out.println("init()");
	}
	public void close(){
		System.out.println("close()");
	}
	
    public Integer getMaxActive() {
		return maxActive;
	}
    public Integer getMaxIdle() {
		return maxIdle;
	}
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriver(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "OpenDataSource [driverClassName=" + driverClassName + ", url=" + url + ", username=" + username
				+ ", password=" + password + ", maxActive=" + maxActive + ", maxIdle=" + maxIdle + "]";
	}
    
}





