package com.test;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.pt.order.dao.OrderDao;
import com.pt.order.entity.Order;
import com.pt.order.vo.OrderVo;
import com.pt.order.vo.SqlOrderCommand;
public class TestOrder01 extends TestBase {
	
	@Test
	public void deleteObjects(){
		//1.创建SqlSession对象
		SqlSession session=
				factory.openSession();
		//2.获取OrderDao对象，并执行删除操作
		OrderDao dao=session.getMapper(OrderDao.class);
		int rows=dao.deleteObjects(new Integer[]{10,20,50});
		session.commit();
		System.out.println("delete.rows="+rows);
		//3.释放资源
		session.close();
	}//SqlSessionFactory-->SqlSession-->Executor
	
	@Test
	public void deleteObject(){
		//1.创建SqlSession对象
		SqlSession session=
		factory.openSession(ExecutorType.BATCH);
		//其中ExecutorType.BATCH表示系统底层会调用
		//BatchExecutor执行器执行sql操作。
		//2.获取OrderDao对象，并执行删除操作
		OrderDao dao=session.getMapper(OrderDao.class);
		dao.deleteObject(9);
		dao.deleteObject(8);
		session.commit();//提交时一次执行(只发送一次sql)
		//3.释放资源
		session.close();
	}//SqlSessionFactory-->SqlSession-->Executor
	
	@Test
	public void testInsertObject(){
		//1.创建SqlSession对象
		SqlSession session=factory.openSession();//SimpleExecutor
		//2.构建订单对象(封装订单信息)
		Order o=new Order();
		o.setCode("201810311110");
		o.setMemberId(1);
		o.setGoodsId(1004);
		o.setTotalPrice(2000.0f);
		o.setStatus(2);
		o.setRemark("order ....");
		//3.将订单对象持久化到数据库
		OrderDao dao=session.getMapper(OrderDao.class);
		int rows=dao.insertObject(o);
		session.commit();
		//4.释放资源
		session.close();
		System.out.println("insert.rows="+rows);
		//思考：如何获取刚刚写入的订单id？
		System.out.println("order.id="+o.getId());
	}

	@Test
	public void testFindPageObjects(){
		//1.创建SqlSession对象
		SqlSession session=factory.openSession();
		//2.获取Dao接口
		OrderDao dao=session.getMapper(OrderDao.class);
		//3.执行查询操作
		SqlOrderCommand cmd=new SqlOrderCommand();
		cmd.setColumn("code");
		cmd.setType("desc");
		List<OrderVo> list=dao.findPageObjects(null);
		//4.输出结果
		for(OrderVo o:list){
		  System.out.println(o.getId()+"/"+o.getCode());
		  //System.out.println(o);
		}
		//5.释放资源
		session.close();
	}
}



