package cn.tarena.pool;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientStart {

	public static void main(String[] args) throws Exception {
		for(int i=0;i<20;i++){
			Socket socket=new Socket("127.0.0.1",8888);
		}
	}
}
