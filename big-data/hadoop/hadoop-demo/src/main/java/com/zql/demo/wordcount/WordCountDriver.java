package com.zql.demo.wordcount;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordCountDriver {
    private static String IP="192.168.227.141";
	public static void main(String[] args) throws Exception {
		//System.setProperty("hadoop.home.dir", "E:\\Java\\tool\\hadoop-2.7.1");
		Configuration conf=new Configuration();
		//--��ȡjob����
		Job job= Job.getInstance(conf);
		
		//--����job������ڵ�������
		job.setJarByClass(WordCountDriver.class);
		
		//--����Mapper�����
		job.setMapperClass(WordCountMapper1.class);
		
		//--����Mapper�����key����
		job.setMapOutputKeyClass(Text.class);
		
		//--����Mapper�����value���ͣ�ע��Text�ĵ�������
		//--hadoop.io��
		job.setMapOutputValueClass(IntWritable.class);
		
		//--����reducer�����
		job.setReducerClass(WordCountReducer1.class);
		
		//--����reduce�����key����
		job.setOutputKeyClass(Text.class);
		
		//--����reduce�����value����
		job.setOutputValueClass(IntWritable.class);
		
		//--���ô�job������reduceTask
		job.setNumReduceTasks(2);
		
		//--��������·����
		FileInputFormat.setInputPaths(job,
				new Path("hdfs://"+ StaticResource.getIp() +":9000/word"));
		
		//--����������·����Ҫ����·�����Ȳ��ܴ���
		FileOutputFormat.setOutputPath(job,
				new Path("hdfs://"+ StaticResource.getIp() + ":9000/word/result"));
		
		//--�ύjob
		job.waitForCompletion(true);
	}
}
