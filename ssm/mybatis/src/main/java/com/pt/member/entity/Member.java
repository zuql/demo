package com.pt.member.entity;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    private static final long serialVersionUID = 6948864912341044105L;
    private Integer id;
    private String nickname;
    private String password;
    private String realname;
    private String gender;
    private String email;
    private String mobile;
    private Integer rank=0;
    private String safequestion;
    private String safeanswer;
    private Date createdTime;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNickname() {
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


    public Integer getRank() {
        return rank;
    }
    public void setRank(Integer rank) {
        this.rank = rank;
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
}

