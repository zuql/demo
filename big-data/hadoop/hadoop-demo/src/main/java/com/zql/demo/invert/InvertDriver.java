package com.zql.demo.invert;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class InvertDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(InvertDriver.class);
		
		job.setMapperClass(InvertMapper1.class);
		
		job.setReducerClass(InvertReducer1.class);
		
		
		job.setMapOutputKeyClass(Text.class);
	
		job.setMapOutputValueClass(IntWritable.class);
		
		
		job.setOutputKeyClass(Text.class);
	
		job.setOutputValueClass(IntWritable.class);

	
		FileInputFormat.addInputPath(job, new Path("hdfs://"+ StaticResource.getIp()+":9000/invert"));
		
		FileOutputFormat.setOutputPath(job,new Path("hdfs://"+ StaticResource.getIp()+":9000/invert/result"));
		
	
		if(job.waitForCompletion(true)){
			Job job2=Job.getInstance(conf);
			job2.setMapperClass(InvertMapper2.class);
			job2.setReducerClass(InvertReducer2.class);
			
			job2.setMapOutputKeyClass(Text.class);
			job2.setMapOutputValueClass(Text.class);
			
			job2.setOutputKeyClass(Text.class);
			job2.setOutputValueClass(Text.class);
			
			FileInputFormat.addInputPath(job2, new Path("hdfs://"+ StaticResource.getIp()+":9000/invert/result"));
			
			FileOutputFormat.setOutputPath(job2,new Path("hdfs://"+ StaticResource.getIp()+":9000/invert/result2"));
			
			job2.waitForCompletion(true);
		}
	}
}
