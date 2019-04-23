package com.zuql.test;

import com.pt.member.entity.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMember01 extends TestBase {

    @Test
    public void testFindObjects(){
        //1.创建SqlSession对象(相当于创建一个连接)
        SqlSession session=factory.openSession();
        //2.执行查询操作(selectList("命名空间"+"元素id"))
        List<Member> list=session.selectList(
                "com.pt.member.dao.MemberDao.findObjects");
        for(Object o:list){
            System.out.println(o);
        }
        //3.释放资源(类似关闭连接)
        session.close();
    }
    @Test
    public void testInsertObject() {
        SqlSession session=
                factory.openSession();//默认事务是手动提交方式,操作执行结束需要手动提交
        //factory.openSession(true);//表示事务自动提交，执行完操作无需commit
        String statement="com.pt.member.dao.MemberDao.insertObject";
        Member m=new Member();
        m.setNickname("xiaoqiang");
        m.setRealname("zhaoqiang");
        m.setPassword("123456");
        m.setGender("MALE");
        m.setEmail("e1@t.com");
        m.setMobile("11111111111");
        m.setRank(1);
        m.setSafequestion("1+1=?");
        m.setSafeanswer("2");
        m.setCreatedTime(new java.util.Date());
        int rows=session.insert(statement,m);
        System.out.println("rows="+rows);
        session.commit();
        session.close();
    }

}
