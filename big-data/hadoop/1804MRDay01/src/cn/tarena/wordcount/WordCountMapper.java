package cn.tarena.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * 知识点
 * 1.job的MapTask如何处理文件块数据，是有Mapper组件类来决定，此类里的代码需要程序员来编写
 * 2.开发一个Mapper组件的方式是让一个类继承Mapper
 * 3.第一个泛型类型对应的MapTask的输入key类型
 * 4.第二个泛型类型对应的MapTask的输入value类型
 * 5.输入key是每行的行首偏移量，所以是LongWritable
 * 6.输入value是每行的内容，所以是Text
 * 7.Writable机制是Hadoop的序列化机制。
 * 常用的类型：LongWritable,IntWritable,Text(String),NullWritable
 * 8.map()方法用于将输入key和输入value传给程序员，有一行数据，map方法就会调用一次
 * 9.第三个泛型类型是MapTask的输出key类型
 * 10.第四个泛型类型是MapTask的输出value类型
 * 11.初学时记住：第一个和第二个泛型写死。 第三个和第四个不固定
 * 
 * @author ysq
 *
 */
public class WordCountMapper extends Mapper<LongWritable,Text,LongWritable,Text>{
	
	@Override
	protected void map(LongWritable key, Text value, 
			Mapper<LongWritable, Text, LongWritable, Text>.Context context)
			throws IOException, InterruptedException {
		
		//--将输入key和输出value,目的是做验证测试
		context.write(key,value);
	}
}
