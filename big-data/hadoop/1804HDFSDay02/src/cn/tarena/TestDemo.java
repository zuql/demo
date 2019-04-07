package cn.tarena;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class TestDemo {
    FileSystem system=null;
    Configuration conf=null;
    @Before
    public void  hadoopEnvironment()throws Exception{
        //以下两行用来指明登陆hadoop的用户和你本地的hadoop-2.6.0所存的目录。
        //System.setProperty("HADOOP_USER_NAME", "hadoop上的用户名");

        System.setProperty("hadoop.home.dir", "E:\\Java\\tool\\hadoop-2.7.1");
        //--获取Hadoop 环境变量对象
        conf=new Configuration();
        //--可以通过此对象来设定环境。通过代码设定的优先级要高于文件设定的优先级
        //--代码设定的生效范围是局部
        conf.set("dfs.repliaction","1");
        //--连接HDFS文件系统
        system=FileSystem.get(new URI("hdfs://192.168.227.141:9000"), conf);
    }
	/*
	 * 通过API连接HDFS并且下载文件到本地
	 */
	@Test
	public void connect_get() throws Exception{

		//--获取HDFS指定文件的输入流
		InputStream in=system.open(new Path("/park01/data.txt"));
		//--获取本地的文件输出流
		OutputStream out=new FileOutputStream(new File("data.txt"));

		//--通过Hadoop提供的工具类，完成数据传输
		IOUtils.copyBytes(in, out, conf);
	}

	/*
	 * 上传文件到HDFS
	 */
	@Test
	public void put() throws Exception{
		/*Configuration conf=new Configuration();
		FileSystem system=FileSystem.get(
				new URI("hdfs://192.168.150.137:9000"), conf);*/

		//--获取HDFS的文件输出流
		OutputStream out=system.create(new Path("/park02/1.txt"));
		//--获取本地的文件输入流
		InputStream in=new FileInputStream(new File("data.txt"));

		IOUtils.copyBytes(in, out, conf);
	}
	@Test
	public void other() throws Exception{
		/*Configuration conf=new Configuration();
		FileSystem system=FileSystem.get(
				new URI("hdfs://192.168.150.137:9000"), conf);
*/
		//--删除指定目录或文件，true表示递归删除
		//system.delete(new Path("/park02"),true);
		//--目录重命名
		system.rename(new Path("/park01"), new Path("/park02"));
	}

	@Test
	public void getBlockLocation() throws Exception{
	/*	Configuration conf=new Configuration();
		FileSystem system=FileSystem.get(
				new URI("hdfs://192.168.150.137:9000"), conf);*/

		//--①参：文件路径  ②参：start控制的是产看块的起始位置 ③参：length:块的终止位置
		BlockLocation[] blks=system.getFileBlockLocations(new Path("/park02/Hadoop第一天课前资料.rar"),0,Integer.MAX_VALUE);

		for(BlockLocation blk:blks){
			System.out.println(blk);
		}
	}
}
