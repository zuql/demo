package cn.tarena.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientStart {

	public static void main(String[] args) throws Exception {
		Socket socket=new Socket();
		socket.connect(new InetSocketAddress("127.0.0.1",8888));
		OutputStream out=socket.getOutputStream();

		out.write("helloworld".getBytes());

		while(true);//保持客户端线程一直开启
	}
}
