package cn.tarena.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * ֪ʶ��
 * 1.job��MapTask��δ����ļ������ݣ�����Mapper�������������������Ĵ�����Ҫ����Ա����д
 * 2.����һ��Mapper����ķ�ʽ����һ����̳�Mapper
 * 3.��һ���������Ͷ�Ӧ��MapTask������key����
 * 4.�ڶ����������Ͷ�Ӧ��MapTask������value����
 * 5.����key��ÿ�е�����ƫ������������LongWritable
 * 6.����value��ÿ�е����ݣ�������Text
 * 7.Writable������Hadoop�����л����ơ�
 * ���õ����ͣ�LongWritable,IntWritable,Text(String),NullWritable
 * 8.map()�������ڽ�����key������value��������Ա����һ�����ݣ�map�����ͻ����һ��
 * 9.����������������MapTask�����key����
 * 10.���ĸ�����������MapTask�����value����
 * 11.��ѧʱ��ס����һ���͵ڶ�������д���� �������͵��ĸ����̶�
 * 
 * @author ysq
 *
 */
public class WordCountMapper extends Mapper<LongWritable,Text,LongWritable,Text>{
	
	@Override
	protected void map(LongWritable key, Text value, 
			Mapper<LongWritable, Text, LongWritable, Text>.Context context)
			throws IOException, InterruptedException {
		
		//--������key�����value,Ŀ��������֤����
		context.write(key,value);
	}
}
