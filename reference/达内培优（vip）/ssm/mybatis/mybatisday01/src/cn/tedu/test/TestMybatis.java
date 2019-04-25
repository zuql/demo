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
 * �������������mybatis�����Ű���
1�������Ự����
2������sqlsession��ִ��SQL
3��������
4���ͷ���Դ
 */
public class TestMybatis {

	//������Ԫ���Է���hello
	@Test
	public void hello() throws IOException{
//		1�������Ự����
		InputStream in = 
				Resources.getResourceAsStream(
						"sqlMapConfig.xml");
				
		SqlSessionFactory ssf = 
				new SqlSessionFactoryBuilder()
				.build(in);
		
//		2������sqlsession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		//��λSQL��λ��namespaceֵ.idֵ
		List<User> list = 
				session.selectList("userns.all");
		
//		3��������
		for (User user : list) {
			System.out.println(user);
		}
		
//		4���ͷ���Դ
		session.close();
		
	}
	
	
	
	
	
	
	
	
	
}
