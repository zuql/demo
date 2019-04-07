package cn.tarena.pool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerStart {

	public static void main(String[] args) throws Exception {
		ServerSocket server=new ServerSocket(8888);
		ExecutorService pool=Executors.newFixedThreadPool(10);

		while(true){
			Socket socket=server.accept();
			pool.execute(new PoolRunner(socket));
		}
	}

}
class PoolRunner implements Runnable{
	private Socket socket;

	public PoolRunner(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		System.out.println("处理当前请求的线程编号:"+Thread.currentThread().getId());

	}

}
