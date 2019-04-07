package cn.tarena.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.junit.Test;

public class TestDemo {

	@Test
	public void server_create_accept() throws Exception{
		//--获取服务端通道，最主要的作用是绑定服务ip和服务端口
		ServerSocketChannel server=ServerSocketChannel.open();
		server.bind(new InetSocketAddress(8888));
		//--变成非阻塞模式，默认是阻塞模式
		server.configureBlocking(false);

		//--获取和对应客户端通信的通道
		SocketChannel sc=server.accept();
		System.out.println("hello");
	}
	@Test
	public void client_create_connect() throws Exception{
		//--获取客户端通道
		SocketChannel sc=SocketChannel.open();
		sc.configureBlocking(false);
		sc.connect(new InetSocketAddress("127.0.0.1",8888));
		System.out.println("hello");
	}
}
