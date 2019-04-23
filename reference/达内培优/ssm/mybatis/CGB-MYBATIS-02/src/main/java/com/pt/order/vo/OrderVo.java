package com.pt.order.vo;
import java.io.Serializable;
import java.util.Date;

import com.pt.member.entity.Member;


/**
 * VO：用于封装订单以及订单相关的会员信息
 * @author Administrator
 */

public class OrderVo implements Serializable{
	private static final long serialVersionUID = 2586258704975775437L;
	private Integer id;
	/**订单编码*/
	private String code;
	/**商品id*/
	private Integer goodsId;
	/**订单总价*/
	private Float   totalprice;
	/**订单状态*/
	private Integer status;
	/**订单备注*/
	private String  remark;
	/**订单创建时间*/
	private Date    createdTime;
	/**借助此属性封装会员信息*/
	private Member member;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Float totalprice) {
		this.totalprice = totalprice;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "OrderVo [id=" + id + ", code=" + code + ", goodsId=" + goodsId + ", totalprice=" + totalprice
				+ ", status=" + status + ", remark=" + remark + ", createdTime=" + createdTime + ", member=" + member
				+ "]";
	}
	
	
}
