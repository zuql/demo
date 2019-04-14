package com.zuql.demo.springbootssmmybatisplus.user.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
// select 字段* from @TableName
//表和类映射
//利用MybatisPlus的注解
@TableName(value="user")	//类和数据库表的映射
public class User implements Serializable {
    @TableId(type= IdType.AUTO)		//主键，自增
    private int id;
    //映射，全局配置驼峰规则，MybatisPlus自动修改
    private String name;
    //对日期类型进行格式转换
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String addRess;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddRess() {
        return addRess;
    }

    public void setAddRess(String addRess) {
        this.addRess = addRess;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateTime=" + birthday +
                ", addRess='" + addRess + '\'' +
                '}';
    }
}
