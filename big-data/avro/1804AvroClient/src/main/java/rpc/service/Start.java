package rpc.service;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

import avro.domain.User;

public class Start {

 public static void main(String[] args) throws Exception {
	NettyTransceiver client=new NettyTransceiver(
				new InetSocketAddress("127.0.0.1",8888));
	
	//--因为接口不能直接使用，avro底层是通过jdk动态代理生成接口的代理对象
	AddService proxy=
		SpecificRequestor.getClient(AddService.class, client);
	
//	int result=proxy.add(2, 3);
//	System.out.println("客户端收到结果:"+result);
	User u1=new User("tom",23);
	proxy.sendUser(u1);
				
	}
}
