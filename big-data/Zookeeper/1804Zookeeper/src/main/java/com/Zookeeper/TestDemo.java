package com.Zookeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

public class TestDemo {
	
	private ZooKeeper zk;
	
	@Before
	public void connect() throws Exception{
		//--zk服务器的ip地址和端口
		//--客户端连接服务端的超时时间，单位是毫秒
		//--watcher接口 监听接口
		//--连接时，如果报 connect refuse异常，检查防火墙
		//--关闭指令:service iptables stop
		//--zk的连接是非阻塞连接，因为zookeeper网络通信框架用的是netty
		//--而netty底层用的是nio通信
		
		final CountDownLatch cdl=new CountDownLatch(1);
		zk=new ZooKeeper("192.168.227.12:2181",3000,
				new Watcher(){

				@Override
				public void process(WatchedEvent event) {
					//--SyncConnected表示连接成功事件
					if(event.getState().equals(KeeperState.SyncConnected)){
						System.out.println("连接成功");
						cdl.countDown();
					}
								
						}
			
		});
		cdl.await();	
		
	}
	/*
	 * 创建节点
	 */
	@Test
	public void create() throws Exception{
		zk.create("/park01","hello".getBytes(),
				Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}
	/*
	 * 获取指定节点数据
	 */
	@Test
	public void getData() throws Exception{
		byte[] data=zk.getData("/park01",null, null);
		System.out.println(new String(data));
	}
	/*
	 * 更新节点数据
	 */
	@Test
	public void setData() throws Exception{
		//--①参:路径  ②参:更新数据 ③数据版本号
		//--数据版本号每更新一次，递增1
		//--一般写成-1,表示无论版本号是多少都会更新
		zk.setData("/park01","1234".getBytes(),-1);
	}
	/*
	 * 删除节点
	 */
	@Test
	public void delete() throws Exception{
		zk.delete("/park01",-1);
	}
	
	/*
	 * 获取指定节点下子节点的名字
	 */
	@Test
	public void getChild() throws Exception{
		List<String> paths= zk.getChildren("/park01",null);
		for(String path:paths){
			System.out.println(path);
		}
	}
	
	@Test
	public void watch_data_changed() throws Exception{
		for(;;){
			final CountDownLatch cdl=new CountDownLatch(1);
			zk.getData("/park01",new Watcher(){

				@Override
				public void process(WatchedEvent event) {
					//--EventType.NodeDataChanged:节点数据发生变化的事件
					if(event.getType().equals(EventType.NodeDataChanged)){
						System.out.println("有数据发生变化");
						try {
							byte[] data=zk.getData("/park01",null,null);
							System.out.println("当前数据:"+new String(data));
						} catch (KeeperException | InterruptedException e) {
							
							e.printStackTrace();
						}
						cdl.countDown();
					}
					
				}
				
			},null);
			cdl.await();
		}
		
		
	}
	/*
	 * 监听节点被删除事件
	 */
	@Test
	public void watch_delete() throws Exception{
		zk.exists("/park01",new Watcher(){

			@Override
			public void process(WatchedEvent event) {
				if(event.getType().equals(EventType.NodeDeleted)){
					System.out.println("节点被删除");
				}
				
			}
			
		});
		while(true);
	}
	
	/*
	 * 监听指定节点下子节点创建或删除的事件
	 */
	@Test
	public void watch_child_changed() throws Exception{
		for(;;){
			final CountDownLatch cdl=new CountDownLatch(1);
			zk.getChildren("/park01",new Watcher(){

				@Override
				public void process(WatchedEvent event) {
					if(event.getType().equals(EventType.NodeChildrenChanged)){
						System.out.println("有子节点发生变化");
						try {
							List<String> paths=zk.getChildren("/park01",null);
							for(String path:paths){
								//--拼接成一个完成的子路径
								path="/park01/"+path;
								zk.getData(path,new Watcher(){

									@Override
									public void process(WatchedEvent event) {
										if(event.getType().equals(EventType.NodeDataChanged)){
											System.out.println("数据发生变化");
										}
										
									}
									
								},null);
							}
							
						} catch (KeeperException | InterruptedException e) {
							
							e.printStackTrace();
						}
					}
					
				}
				
			});
			cdl.await();
		}
	}
}
