package com.Avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import avro.domain.User;

public class TestDemo {

	@Test
	public void create(){
		User u1=new User();
		u1.setUsername("tom");
		u1.setAge(23);
		
		User u2=new User("rose",25);
		
		User u3=new User().newBuilder()
				.setUsername("jim").setAge(30).build();
		
		//--基于某个对象来创建一个新对象
		//--底层用的clone接口(克隆机制)
		User u4=new User().newBuilder(u2).setAge(30).build();
		
		System.out.println(u1);
		System.err.println(u4);
	}
	
	@Test
	public void write() throws Exception{
		//--B语言创始人，C语言创始人，Unix创始人
		User u1=new User("Ken Tompson",194375);
		User u2=new User("丹尼斯·里奇",194170);
		
		DatumWriter<User> dw=new SpecificDatumWriter<>(User.class);
		DataFileWriter<User> dfw=new DataFileWriter<>(dw);
		
		//--创建底层的文件输出通道 ①参:序列化类的模式 ②文件路径
		dfw.create(u1.getSchema(),new File("1.txt"));
		//--把对象数据写到文件中
		dfw.append(u1);
		dfw.append(u2);
		
		dfw.close();
		
		
	}
	@Test
	public void read() throws Exception{
		DatumReader<User> dr=
				new SpecificDatumReader<>(User.class);
		DataFileReader<User> dfr=
				new DataFileReader<>(new File("1.txt"),dr);
		
		//--通过迭代器，迭代出对象数据
		while(dfr.hasNext()){
			System.out.println(dfr.next());
		}
		
	}
}
