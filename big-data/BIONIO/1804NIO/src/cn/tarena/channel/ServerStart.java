package cn.tarena.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerStart {

	public static void main(String[] args) throws Exception {
		ServerSocketChannel ssc=ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.bind(new InetSocketAddress(8888));


		SocketChannel sc=null;
		while(sc==null){
			sc=ssc.accept();
		}
		System.out.println("有客户端接入");
		//--设置和客户端通道非阻塞模式
		sc.configureBlocking(false);

		ByteBuffer buffer=ByteBuffer.allocate(10);

		sc.read(buffer);
		String result=new String(buffer.array());
		System.out.println("服务端收到客户端的数据:"+result);

	}
}
