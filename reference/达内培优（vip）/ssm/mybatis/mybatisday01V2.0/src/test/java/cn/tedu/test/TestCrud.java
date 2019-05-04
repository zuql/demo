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
 * ������������mybatis��crud����
 */
public class TestCrud {

	
	
	// ��ִ��@Test֮ǰ��ִ��@Before
	
	//�����Ự�������̰߳�ȫ��
	SqlSessionFactory ssf;
	
	@Before
	public void init() {
		try {
			// 1,�����Ự����
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
			ssf = new SqlSessionFactoryBuilder().build(in);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ��ѯ��������
	@Test
	public void findAll() {
		SqlSession session = null;

		try {
			// 1�������Ự����
			// ���غ��������ļ�
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");

			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

			// 2,����sqlsession����,ִ��SQL
			session = ssf.openSession();
			// namespaceֵ.idֵ
			List<User> list = session.selectList("userns.findAll");

			// 3,������
			for (User user : list) {
				System.out.println(user);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4,�ͷ���Դ
			session.close();
		}

	}

	// ��ѯ�ܼ�¼��
	@Test
	public void count() {
		SqlSession session = null;
		try {
			// 1,�����Ự����
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");

			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

			// 2������sqlsession��ִ��SQL
			session = ssf.openSession();
			// namespaceֵ+idֵ
			int i = session.selectOne("userns.count");

			// 3,������
			System.out.println(i);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4,�ͷ���Դ
			if (session != null)
				session.close();
		}

	}
	
	
	//����id��ѯ��¼
	@Test
	public void findOne(){
		//����sqlSession��ִ��SQL
		SqlSession session = ssf.openSession();
		//namespaceֵ.idֵ
		User user = session.selectOne("userns.findOne");
		
		//������
		System.out.println(user);
		//�ͷ���Դ
		session.close();
	}
	
	
	
	//����id��ѯ��¼
	@Test
	public void findOne2(){
		//����sqlSession��ִ��SQL
		SqlSession session = ssf.openSession();
		//namespaceֵ.idֵ
		User user =
				session.selectOne("userns.findOne2",129);
		
		//������
		System.out.println(user);
		//�ͷ���Դ
		session.close();
	}
	
	
	//����һ����¼
	@Test
	public void save(){
		//1������SQLsession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		//����sqlsessionִ�в����SQL
		User user = new User();
		user.setName("������");
		user.setAddr("����");
		user.setAge(38);
		
		//insert()��һ���Ƕ�λSQL��
		//�ڶ�����SQL��Ҫ��user���͵Ĳ���

		//namespaceֵ.idֵ
		session.insert("userns.save", user);
		
		//�ֶ��ύ����
		//��������ύ�������ݿ��޸ı䣩
		session.commit();
		
		//�ͷ���Դ
		session.close();
		
	}
	
	//�޸�ָ����¼
	@Test
	public void gengxin(){
		//1������sqlsession��ִ��SQL
		SqlSession session = ssf.openSession(true);//true�����Զ��ύ����
		
		//����SQLsessionִ�в�ѯ��SQL
		User user = new User();
		user.setAge(84);
		user.setName("������");
		
		//update()��һ���Ƕ�λSQL��
		//�ڶ�����SQL��Ҫ��user���͵Ĳ���
		session.update("userns.gengxin",user);
		
		//�ͷ���Դ
		session.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
