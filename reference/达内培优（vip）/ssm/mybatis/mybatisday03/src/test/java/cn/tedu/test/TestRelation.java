package cn.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.dao.UserInfoDao;
import cn.tedu.pojo.Orders;
import cn.tedu.pojo.UserInfo;

/**
 * 这个类用来完成对象关系的测试
 */
public class TestRelation {

	//1,创建sqlsessionfactory工厂
	
	SqlSessionFactory ssf;
	
	@Before//在执行@Test之前执行@Before
	public void init(){
		try {
			InputStream in = 
					Resources.getResourceAsStream(
							"sqlMapConfig.xml");
		
			ssf = new SqlSessionFactoryBuilder()
						.build(in);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	//测试一对一的关系
	@Test
	public void association(){
		//2,创建SQLsession，执行SQL
		SqlSession session = ssf.openSession();
		
		//利用接口开发
		UserInfoDao dao = 
				session.getMapper(
						UserInfoDao.class);
		
		//调用接口里的方法，把数据放入缓存中。。。
		UserInfo info = 
				dao.findExtraByUser(1);
		
		UserInfo info2 = 
				dao.findExtraByUser(1);//从一级缓存中取。。。
		//3,处理结果
		System.out.println(info);
		System.out.println(info2);
		//4,释放资源
		session.close();
		
		//----测试二级缓存
		session = ssf.openSession();
		UserInfoDao dao2 = 
				session.getMapper(
						UserInfoDao.class);
		UserInfo info3 = 
				dao2.findExtraByUser(1);
		System.out.println("33333333333"+info3);
		
		
	}
	
	//测试一对多的关系
	@Test
	public void collection(){
//		1,创建SQLsession，执行SQL
		SqlSession session = ssf.openSession();
		
		//利用接口开发
		UserInfoDao dao = 
				session.getMapper(
						UserInfoDao.class);
		
		//调用接口里的方法
		List<UserInfo> list = 
				dao.findOrdersByUser(1);
		
//		2，处理结果
		for (UserInfo info : list) {
			System.out.println(info);
		}
		
//		3，释放资源
		session.close();
		
		
		
	}
	
	
	
	
	
	
	
	
}
