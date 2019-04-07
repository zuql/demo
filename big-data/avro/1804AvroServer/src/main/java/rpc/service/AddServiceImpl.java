package rpc.service;

import org.apache.avro.AvroRemoteException;

import avro.domain.User;

public class AddServiceImpl implements AddService{

	@Override
	public int add(int a, int b) throws AvroRemoteException {
		
		return a+b;
	}

	@Override
	public Void sendUser(User u) throws AvroRemoteException {
		System.out.println("服务端收到对象:"+u);
		return null;
	}

}
