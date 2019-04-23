package com.pt.member.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 会员实体对象:pojo对象(持久化对象)
 * @author Administrator
 * 此对象与t_members有映射关系
 */
public class Member implements Serializable{
	private static final long serialVersionUID = -1263801704994422093L;
	/**会员id*/
	private Integer id;
	/**会员名称*/
	private String nickname;
	/**会员密码*/
	private String password;
	/**会员真实姓名*/
	private String realname;
	/**会员性别*/
	private String gender;
	/**邮箱*/
	private String email;
	/**手机号*/
	private String mobile;
	/**会员等级*/
	private Integer rank=0;
	/**安全问题*/
	private String safequestion;
	/**安全答案*/
	private String safeanswer;
	/**创建时间*/
	private Date createdTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		System.out.println("getNickname()");
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getSafequestion() {
		return safequestion;
	}
	public void setSafequestion(String safequestion) {
		this.safequestion = safequestion;
	}
	public String getSafeanswer() {
		return safeanswer;
	}
	public void setSafeanswer(String safeanswer) {
		this.safeanswer = safeanswer;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", nickname=" + nickname + ", password=" + password + ", realname=" + realname
				+ ", gender=" + gender + ", email=" + email + ", mobile=" + mobile + ", rank=" + rank
				+ ", safequestion=" + safequestion + ", safeanswer=" + safeanswer + ", createdTime=" + createdTime
				+ "]";
	}

}
