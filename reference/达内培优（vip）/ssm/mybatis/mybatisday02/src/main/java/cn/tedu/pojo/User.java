package cn.tedu.pojo;
/**
 * �����������User����ӳ���ϵ
Ҫ������������ͱ��ֶ�������һ��
 */
public class User {
	
	//id
	private int id;
	
	//�û���
	private String name;
	
	//��ַ
	private String addr;
	
	//����
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
