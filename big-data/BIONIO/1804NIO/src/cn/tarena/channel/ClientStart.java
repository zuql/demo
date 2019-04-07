package cn.tarena.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientStart {

	public static void main(String[] args) throws Exception {
		SocketChannel sc=SocketChannel.open();
		
		sc.connect(new InetSocketAddress("127.0.0.1",8888));
		
		ByteBuffer buffer=ByteBuffer.wrap("helloworld".getBytes());
		sc.write(buffer);
		
		while(true);
	
	}
}
