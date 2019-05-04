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

import cn.tedu.pojo.User;

/**
 * 这个类用来完成mybatis的crud测试
 */
public class TestCrud {

	
	
	// 在执行@Test之前就执行@Before
	
	//声明会话工厂，线程安全的
	SqlSessionFactory ssf;
	
	@Before
	public void init() {
		try {
			// 1,创建会话工厂
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
			ssf = new SqlSessionFactoryBuilder().build(in);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 查询所有数据
	@Test
	public void findAll() {
		SqlSession session = null;

		try {
			// 1，创建会话工厂
			// 加载核心配置文件
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");

			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

			// 2,创建sqlsession对象,执行SQL
			session = ssf.openSession();
			// namespace值.id值
			List<User> list = session.selectList("userns.findAll");

			// 3,处理结果
			for (User user : list) {
				System.out.println(user);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4,释放资源
			session.close();
		}

	}

	// 查询总记录数
	@Test
	public void count() {
		SqlSession session = null;
		try {
			// 1,创建会话工厂
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");

			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

			// 2，创建sqlsession，执行SQL
			session = ssf.openSession();
			// namespace值+id值
			int i = session.selectOne("userns.count");

			// 3,处理结果
			System.out.println(i);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4,释放资源
			if (session != null)
				session.close();
		}

	}
	
	
	//根据id查询记录
	@Test
	public void findOne(){
		//创建sqlSession，执行SQL
		SqlSession session = ssf.openSession();
		//namespace值.id值
		User user = session.selectOne("userns.findOne");
		
		//处理结果
		System.out.println(user);
		//释放资源
		session.close();
	}
	
	
	
	//根据id查询记录
	@Test
	public void findOne2(){
		//创建sqlSession，执行SQL
		SqlSession session = ssf.openSession();
		//namespace值.id值
		User user =
				session.selectOne("userns.findOne2",129);
		
		//处理结果
		System.out.println(user);
		//释放资源
		session.close();
	}
	
	
	//新增一条记录
	@Test
	public void save(){
		//1，创建SQLsession，执行SQL
		SqlSession session = ssf.openSession();
		
		//利用sqlsession执行插入的SQL
		User user = new User();
		user.setName("张慎政");
		user.setAddr("河南");
		user.setAge(38);
		
		//insert()第一个是定位SQL，
		//第二个是SQL需要的user类型的参数

		//namespace值.id值
		session.insert("userns.save", user);
		
		//手动提交事务
		//（如果不提交事务，数据库无改变）
		session.commit();
		
		//释放资源
		session.close();
		
	}
	
	//修改指定记录
	@Test
	public void gengxin(){
		//1，创建sqlsession，执行SQL
		SqlSession session = ssf.openSession(true);//true可以自动提交事务
		
		//利用SQLsession执行查询的SQL
		User user = new User();
		user.setAge(84);
		user.setName("张慎政");
		
		//update()第一个是定位SQL，
		//第二个是SQL需要的user类型的参数
		session.update("userns.gengxin",user);
		
		//释放资源
		session.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
