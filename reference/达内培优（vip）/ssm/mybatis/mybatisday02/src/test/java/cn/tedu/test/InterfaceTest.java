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
 * �������������mapper�ӿ�
 */
public class InterfaceTest {

	SqlSessionFactory ssf =null;
	
	@Before
	public void init(){
		try {
			//��ȡ�Ự����
			InputStream in = 
					Resources.getResourceAsStream(
					"sqlMapConfig.xml");
		
			ssf = new SqlSessionFactoryBuilder()
					.build(in);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	//��ѯuser�����������
	@Test
	public void All(){
		//1,��ȡsqlsession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		//���ýӿڿ���
		UserMapperDao dao = 
				session.getMapper(
						UserMapperDao.class);
		
		//���ýӿڣ�ִ�нӿ��еķ���findAll
		//�ӿ��з����� =  UserMapper.xml�ж����SQL��idֵ
		List<User> list = dao.findAll();
		
		//2,������
		for (User user : list) {
			System.out.println(user);
		}
		
		//3,�ͷ���Դ
		session.close();
		
	}
	
	//<!-- ��ѯ�ܼ�¼�� -->
	@Test
	public void count(){
//		1,����SQLsession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		//���ýӿڿ���
		UserMapperDao dao = 
				session.getMapper(
						UserMapperDao.class);
		
		//���ýӿ���ķ���
		int count = dao.count();
		
//		2��������
		System.out.println(count);
		
//		3���ͷ���Դ
		session.close();
		
	}
	
	
	//	<!-- ����id��ѯ��¼ -->
	@Test
	public void findOne(){
//		1,����sqlsession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		//���ýӿڿ���
		UserMapperDao dao = 
				session.getMapper(
						UserMapperDao.class);
		
		//���ýӿ����findOne����
		User user = dao.findOne(136);
		
//		2��������
		System.out.println(user);
		
//		3���ͷ���Դ
		session.close();
		
	}
	
//	����һ����¼ 
	@Test
	public void save(){
//		1,����SQLsession����ִ��SQL
		SqlSession session = ssf.openSession();
		
		//���ýӿڿ���
		UserMapperDao dao = 
				session.getMapper(
						UserMapperDao.class);
		
		User user = new User();
		user.setName("�Ʒ�");
		user.setAddr("����");
		user.setAge(48);
		
		//���ýӿ����save����
		dao.save(user);
		
//		2��������
		session.commit();//�ֶ��ύ����
//		3���ͷ���Դ
		session.close();
		
	}
	
	
	
	
	
}
