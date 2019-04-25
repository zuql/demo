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

import cn.tedu.dao.UserMapperDao;
import cn.tedu.pojo.User;

/**
 * 这个类用来测试mapper接口
 */
public class InterfaceTest {

	SqlSessionFactory ssf =null;
	
	@Before
	public void init(){
		try {
			//获取会话工厂
			InputStream in = 
					Resources.getResourceAsStream(
					"sqlMapConfig.xml");
		
			ssf = new SqlSessionFactoryBuilder()
					.build(in);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	//查询user表的所有数据
	@Test
	public void All(){
		//1,获取sqlsession，执行SQL
		SqlSession session = ssf.openSession();
		
		//利用接口开发
		UserMapperDao dao = 
				session.getMapper(
						UserMapperDao.class);
		
		//利用接口，执行接口中的方法findAll
		//接口中方法名 =  UserMapper.xml中定义的SQL的id值
		List<User> list = dao.findAll();
		
		//2,处理结果
		for (User user : list) {
			System.out.println(user);
		}
		
		//3,释放资源
		session.close();
		
	}
	
	//<!-- 查询总记录数 -->
	@Test
	public void count(){
//		1,创建SQLsession，执行SQL
		SqlSession session = ssf.openSession();
		
		//利用接口开发
		UserMapperDao dao = 
				session.getMapper(
						UserMapperDao.class);
		
		//调用接口里的方法
		int count = dao.count();
		
//		2，处理结果
		System.out.println(count);
		
//		3，释放资源
		session.close();
		
	}
	
	
	//	<!-- 根据id查询记录 -->
	@Test
	public void findOne(){
//		1,创建sqlsession，执行SQL
		SqlSession session = ssf.openSession();
		
		//利用接口开发
		UserMapperDao dao = 
				session.getMapper(
						UserMapperDao.class);
		
		//调用接口里的findOne方法
		User user = dao.findOne(136);
		
//		2，处理结果
		System.out.println(user);
		
//		3，释放资源
		session.close();
		
	}
	
//	新增一条记录 
	@Test
	public void save(){
//		1,创建SQLsession对象，执行SQL
		SqlSession session = ssf.openSession();
		
		//利用接口开发
		UserMapperDao dao = 
				session.getMapper(
						UserMapperDao.class);
		
		User user = new User();
		user.setName("唐丰");
		user.setAddr("地狱");
		user.setAge(48);
		
		//调用接口里的save方法
		dao.save(user);
		
//		2，处理结果
		session.commit();//手动提交事务
//		3，释放资源
		session.close();
		
	}
	
	
	
	
	
}
