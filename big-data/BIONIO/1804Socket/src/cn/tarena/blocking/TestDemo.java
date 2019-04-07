package cn.tarena.blocking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TestDemo {

	/*
	 * Listens for a connection to be made to this socket and accepts
	 * it. The method blocks until a connection is made.
	 * accept此方法会产生阻塞，直到有一个客户端接入，阻塞放开
	 *
	 * this method
	 * blocks until input data is available,
	 * the end of the stream is detected
	 * read()方法也会产生阻塞，阻塞放开的条件是有数据可读
	 *
	 * write()方法也会产生阻塞，当一方写，但另一方不读，写出到一定量时，就会产生阻塞
	 */
	@Test
	public void testAccept_Read_Write() throws IOException{
		ServerSocket server=new ServerSocket(8888);
		Socket socket=server.accept();

		InputStream in=socket.getInputStream();
		//--服务端和客户端连接之后，读数据，但是客户端并不发数据
//		in.read();
//		System.out.println("hello");
		OutputStream out=socket.getOutputStream();
		for(int i=0;i<100000;i++){
			out.write("helloworld".getBytes());
			System.out.println(i);
		}
	}
	/*
	 * The connection
	 * will then block until established or an error occurs
	 * connect也会产生阻塞，阻塞放开的条件是真正建立连接或有异常抛出
	 */
	@Test
	public void testConnect() throws Exception{
		Socket socket=new Socket();
		socket.connect(new InetSocketAddress("127.0.0.1",8888));
		while(true);//保持客户端连接一直开启

	}
}
