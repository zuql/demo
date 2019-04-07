package com.zql.demo.combine;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountDriver {
	
	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(WordCountDriver.class);
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		//--设置combine组件类，如果不设定，默认是没有comine过程的
		//--combine的作用是让合并工作在MapTask提前发生。
		//--可以减少reduceTask的合并负载
		//--使用combine机制，不能改变最后的结果
		job.setCombinerClass(WordCountCombiner.class);
		
		FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.150.137:9000/word"));
		FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.150.137:9000/word/result"));
		
		job.waitForCompletion(true);
	}

}
