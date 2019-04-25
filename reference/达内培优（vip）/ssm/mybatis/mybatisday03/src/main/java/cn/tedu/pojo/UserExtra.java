package cn.tedu.pojo;

import java.io.Serializable;

/**
 * 用户扩展对象
 * 这个类用来封装user_extra表的数据
 */
public class UserExtra implements Serializable{
	
	//id
	private int id;
	
	//工作
	private String work;
	
	//薪水
	private Double salary;
	
	//用户id
	private int userId;

	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserExtra [id=" + id + ", work=" + work + ", salary=" + salary + ", userId=" + userId + "]";
	}
	
}
