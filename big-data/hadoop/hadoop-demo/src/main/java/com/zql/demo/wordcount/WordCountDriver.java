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
		//--获取job对象
		Job job= Job.getInstance(conf);
		
		//--设置job方法入口的驱动类
		job.setJarByClass(WordCountDriver.class);
		
		//--设置Mapper组件类
		job.setMapperClass(WordCountMapper1.class);
		
		//--设置Mapper的输出key类型
		job.setMapOutputKeyClass(Text.class);
		
		//--设置Mapper的输出value类型，注意Text的导包问题
		//--hadoop.io包
		job.setMapOutputValueClass(IntWritable.class);
		
		//--设置reducer组件类
		job.setReducerClass(WordCountReducer1.class);
		
		//--设置reduce的输出key类型
		job.setOutputKeyClass(Text.class);
		
		//--设置reduce的输出value类型
		job.setOutputValueClass(IntWritable.class);
		
		//--设置此job有两个reduceTask
		job.setNumReduceTasks(2);
		
		//--设置输入路径。
		FileInputFormat.setInputPaths(job,
				new Path("hdfs://"+ StaticResource.getIp() +":9000/word"));
		
		//--设置输出结果路径，要求结果路径事先不能存在
		FileOutputFormat.setOutputPath(job,
				new Path("hdfs://"+ StaticResource.getIp() + ":9000/word/result"));
		
		//--提交job
		job.waitForCompletion(true);
	}
}
