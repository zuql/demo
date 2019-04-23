package com.pt.order.entity;
import java.io.Serializable;
import java.util.Date;
/**
 * POJO:此对象用于实现与表中记录的映射
 * 应用：
 * 1)Orderdao 
 * int insertObject(Order entity)
 * 2)OrderMapper.xml
 * <insert id=“insertObject”
 *         parameterType="com.pt.order.entity.Order">
 *    insert into t_orders
 *    (code,memberId,....)
 *    values
 *    (#{code},#{memberId})
 * </insert>
 */
public class Order implements Serializable{
	private static final long serialVersionUID = 8552549819404782325L;
	private Integer id;
	/**订单编码*/
	private String code;
	/**会员id*/
	private Integer memberId;
	/**商品id*/
	private Integer goodsId;
	/**订单总价*/
	private Float   totalPrice;
	/**订单状态*/
	private Integer status;
	/**订单备注*/
	private String  remark;
	/**订单创建时间*/
	private Date    createdTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
		System.out.println("id="+id);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", code=" + code + ", memberId=" + memberId + ", goodsId=" + goodsId
				+ ", totalPrice=" + totalPrice + ", status=" + status + ", remark=" + remark + ", createdTime="
				+ createdTime + "]";
	}
	
}
