package cn.tedu.pojo;
/**
 * 这个类用来和User表做映射关系
要求：属性名必须和表字段名保持一致
 */
public class User {
	
	//id
	private int id;
	
	//用户名
	private String name;
	
	//地址
	private String addr;
	
	//年龄
	private int age;

	//getter setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}

	
}
