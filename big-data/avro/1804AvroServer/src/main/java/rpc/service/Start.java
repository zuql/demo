package rpc.service;

import java.net.InetSocketAddress;

import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.specific.SpecificResponder;

public class Start {

	public static void main(String[] args) {
		System.out.println("服务端启动");
		NettyServer server=new NettyServer(
				new SpecificResponder(AddService.class,
						              new AddServiceImpl()), 
				new InetSocketAddress(8888));
	}
}
