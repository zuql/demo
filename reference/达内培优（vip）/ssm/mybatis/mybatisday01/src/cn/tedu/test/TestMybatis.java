package cn.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.tedu.pojo.User;

/**
 * 这个类用来测试mybatis的入门案例
1，创建会话工厂
2，创建sqlsession，执行SQL
3，处理结果
4，释放资源
 */
public class TestMybatis {

	//创建单元测试方法hello
	@Test
	public void hello() throws IOException{
//		1，创建会话工厂
		InputStream in = 
				Resources.getResourceAsStream(
						"sqlMapConfig.xml");
				
		SqlSessionFactory ssf = 
				new SqlSessionFactoryBuilder()
				.build(in);
		
//		2，创建sqlsession，执行SQL
		SqlSession session = ssf.openSession();
		
		//定位SQL的位置namespace值.id值
		List<User> list = 
				session.selectList("userns.all");
		
//		3，处理结果
		for (User user : list) {
			System.out.println(user);
		}
		
//		4，释放资源
		session.close();
		
	}
	
	
	
	
	
	
	
	
	
}
