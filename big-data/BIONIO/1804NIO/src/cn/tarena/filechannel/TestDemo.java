package cn.tarena.filechannel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class TestDemo {

	@Test
	public void write() throws Exception{
		//--获取文件通道。基于某种流（比如文件输出流或输入流来创建)
		FileChannel fc=
				new FileOutputStream(new File("1.txt")).getChannel();

		ByteBuffer buffer=ByteBuffer.wrap("helloworld".getBytes());
		fc.write(buffer);

		fc.close();
	}
	@Test
	public void read() throws Exception{
		FileChannel fc=new FileInputStream(new File("1.txt")).getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(10);
		//--文件通道可以通过位置灵活的操作数据
		//--文件通道底层可以使用zero copy 零拷贝技术
		fc.position(4);
		fc.read(buffer);
		System.out.println(new String(buffer.array()));
		fc.close();
	}
}
