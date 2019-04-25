package cn.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.pojo.User;

/**
 * 这个类用来测试动态SQL拼接
 */
public class DynamicSqlTest {
	
	SqlSessionFactory ssf = null;
	
	@Before
	public void init(){
		try {
			//1，创建会话工厂
			InputStream in = 
					Resources.getResourceAsStream(
					"sqlMapConfig.xml");
			
			ssf = new SqlSessionFactoryBuilder()
					.build(in);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	//单元测试方法
	//Sql+include标签
	@Test
	public void SqlInclude(){
		//2，创建SqlSession，执行SQL
		SqlSession session = ssf.openSession();
		
		//第一个是SQL的定位，第二个是SQL的参数值
		User user = session.selectOne(
					"usernp.findOne",131);
		
		//3，处理结果
		System.out.println(user);
		
		//4，释放资源
		session.close();
		
	}
	
	//if标签
	@Test
	public void ifsql(){
		//1,创建sqlsession，执行SQL
		SqlSession session = ssf.openSession();
		
		User user = new User();
		user.setId(131);
		user.setName("张慎政");
		user.setAddr("河南");
		
		//第一个是SQL定位，第二个是SQL需要的参数
		session.selectList("usernp.ifsql",user);
		
		//2,处理结果
		System.out.println(user);
		
		//3,释放资源
		session.close();
	}
	
	
	//set标签
	@Test
	public void SetSql(){
		//1,创建SQLsession，执行SQL
		SqlSession session = ssf.openSession();
		session.update("usernp.setsql");
		
		//2,处理结果
		session.commit();//手动提交事务
		//3,释放资源
		session.close();
	}
	
	
	//foreach标签的array形式
	@Test
	public void foreacharray(){
//		1,创建SQLsession，执行SQL
		SqlSession session = ssf.openSession();
		
		//第一个是SQL定位，第二个是SQL需要的数组类型的参数
		List<User> list = 
				session.selectList(
						"usernp.foreacharray",
						new int[]{131,132,134});
		
//		2，处理结果
		for (User user : list) {
			System.out.println(user);
		}
		
//		3，释放资源
		session.close();
		
	}
	
	//foreach标签的list形式
	@Test
	public void foreachlist(){
//		1,创建SQLsession，执行SQL
		SqlSession session = ssf.openSession();
		
		List list = new ArrayList();
		list.add(132);
		list.add(134);
		
		//第一个是SQL定位，第二个是SQL需要的list类型的参数
		session.delete(
				"usernp.foreachlist",list);
		
//		2，处理结果
		session.commit();//增删改必须手动提交事务
		
//		3，释放资源
		session.close();
	}
	
	//foreach标签的map形式
	@Test
	public void foreachgengxin(){
//		1,创建SQLsession执行SQL
		SqlSession session = ssf.openSession();
		
		Map map = new HashMap();
		map.put("key", new int[]{131,135,136});
		
		//第一个是SQL定位，
		//第二个是SQL需要传入的map类型的参数
		session.update(
				"usernp.foreachgengxin",map);
		
//		2，处理结果
		session.commit();//手动提交事务
		
//		3，释放资源
		session.close();
		
		
	}
	
	
	
	
	
}
