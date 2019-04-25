package cn.tedu.pojo;
/**
 * 订单对象
 * 这个类用来封装orders表的数据
 */
public class Orders {

	//id
	private int id;
	
	//用户id
	private int userId;
	
	//订单号
	private int orderNo;
	
	//订单描述
	private String orderDesc;
	
	//订单金额
	private Double price;

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", orderNo=" + orderNo + ", orderDesc=" + orderDesc
				+ ", price=" + price + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
