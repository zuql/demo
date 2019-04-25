package cn.tedu.pojo;

import java.io.Serializable;

/**
 * �û���չ����
 * �����������װuser_extra�������
 */
public class UserExtra implements Serializable{
	
	//id
	private int id;
	
	//����
	private String work;
	
	//нˮ
	private Double salary;
	
	//�û�id
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
