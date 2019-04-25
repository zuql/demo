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
 * ������������Զ�̬SQLƴ��
 */
public class DynamicSqlTest {
	
	SqlSessionFactory ssf = null;
	
	@Before
	public void init(){
		try {
			//1�������Ự����
			InputStream in = 
					Resources.getResourceAsStream(
					"sqlMapConfig.xml");
			
			ssf = new SqlSessionFactoryBuilder()
					.build(in);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	//��Ԫ���Է���
	//Sql+include��ǩ
	@Test
	public void SqlInclude(){
		//2������SqlSession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		//��һ����SQL�Ķ�λ���ڶ�����SQL�Ĳ���ֵ
		User user = session.selectOne(
					"usernp.findOne",131);
		
		//3��������
		System.out.println(user);
		
		//4���ͷ���Դ
		session.close();
		
	}
	
	//if��ǩ
	@Test
	public void ifsql(){
		//1,����sqlsession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		User user = new User();
		user.setId(131);
		user.setName("������");
		user.setAddr("����");
		
		//��һ����SQL��λ���ڶ�����SQL��Ҫ�Ĳ���
		session.selectList("usernp.ifsql",user);
		
		//2,������
		System.out.println(user);
		
		//3,�ͷ���Դ
		session.close();
	}
	
	
	//set��ǩ
	@Test
	public void SetSql(){
		//1,����SQLsession��ִ��SQL
		SqlSession session = ssf.openSession();
		session.update("usernp.setsql");
		
		//2,������
		session.commit();//�ֶ��ύ����
		//3,�ͷ���Դ
		session.close();
	}
	
	
	//foreach��ǩ��array��ʽ
	@Test
	public void foreacharray(){
//		1,����SQLsession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		//��һ����SQL��λ���ڶ�����SQL��Ҫ���������͵Ĳ���
		List<User> list = 
				session.selectList(
						"usernp.foreacharray",
						new int[]{131,132,134});
		
//		2��������
		for (User user : list) {
			System.out.println(user);
		}
		
//		3���ͷ���Դ
		session.close();
		
	}
	
	//foreach��ǩ��list��ʽ
	@Test
	public void foreachlist(){
//		1,����SQLsession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		List list = new ArrayList();
		list.add(132);
		list.add(134);
		
		//��һ����SQL��λ���ڶ�����SQL��Ҫ��list���͵Ĳ���
		session.delete(
				"usernp.foreachlist",list);
		
//		2��������
		session.commit();//��ɾ�ı����ֶ��ύ����
		
//		3���ͷ���Դ
		session.close();
	}
	
	//foreach��ǩ��map��ʽ
	@Test
	public void foreachgengxin(){
//		1,����SQLsessionִ��SQL
		SqlSession session = ssf.openSession();
		
		Map map = new HashMap();
		map.put("key", new int[]{131,135,136});
		
		//��һ����SQL��λ��
		//�ڶ�����SQL��Ҫ�����map���͵Ĳ���
		session.update(
				"usernp.foreachgengxin",map);
		
//		2��������
		session.commit();//�ֶ��ύ����
		
//		3���ͷ���Դ
		session.close();
		
		
	}
	
	
	
	
	
}
