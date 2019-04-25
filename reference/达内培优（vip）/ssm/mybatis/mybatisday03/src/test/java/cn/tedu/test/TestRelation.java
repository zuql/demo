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
 * �����������ɶ����ϵ�Ĳ���
 */
public class TestRelation {

	//1,����sqlsessionfactory����
	
	SqlSessionFactory ssf;
	
	@Before//��ִ��@Test֮ǰִ��@Before
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
	
	
	//����һ��һ�Ĺ�ϵ
	@Test
	public void association(){
		//2,����SQLsession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		//���ýӿڿ���
		UserInfoDao dao = 
				session.getMapper(
						UserInfoDao.class);
		
		//���ýӿ���ķ����������ݷ��뻺���С�����
		UserInfo info = 
				dao.findExtraByUser(1);
		
		UserInfo info2 = 
				dao.findExtraByUser(1);//��һ��������ȡ������
		//3,������
		System.out.println(info);
		System.out.println(info2);
		//4,�ͷ���Դ
		session.close();
		
		//----���Զ�������
		session = ssf.openSession();
		UserInfoDao dao2 = 
				session.getMapper(
						UserInfoDao.class);
		UserInfo info3 = 
				dao2.findExtraByUser(1);
		System.out.println("33333333333"+info3);
		
		
	}
	
	//����һ�Զ�Ĺ�ϵ
	@Test
	public void collection(){
//		1,����SQLsession��ִ��SQL
		SqlSession session = ssf.openSession();
		
		//���ýӿڿ���
		UserInfoDao dao = 
				session.getMapper(
						UserInfoDao.class);
		
		//���ýӿ���ķ���
		List<UserInfo> list = 
				dao.findOrdersByUser(1);
		
//		2��������
		for (UserInfo info : list) {
			System.out.println(info);
		}
		
//		3���ͷ���Դ
		session.close();
		
		
		
	}
	
	
	
	
	
	
	
	
}
