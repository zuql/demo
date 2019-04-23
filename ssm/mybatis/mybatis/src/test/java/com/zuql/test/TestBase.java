package com.zuql.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;

public class TestBase {
    public SqlSessionFactory factory;

    @Before
    public void init() throws IOException{
        String resoure="mybatis-configs.xml";
        factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resoure));

    }
}
