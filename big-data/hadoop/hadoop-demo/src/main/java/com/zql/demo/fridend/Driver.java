package com.zql.demo.fridend;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver {

	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(Driver.class);
		job.setMapperClass(FriendMapper.class);
		job.setReducerClass(FriendReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path("hdfs://"+ StaticResource.getIp()+":9000/friend"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://"+ StaticResource.getIp()+":9000/friend/result"));
		
		if(job.waitForCompletion(true)){
			Job job2=Job.getInstance(conf);
			job2.setMapperClass(SecFriendMapper.class);
			job2.setReducerClass(SecFriendReducer.class);
			
			job2.setMapOutputKeyClass(Text.class);
			job2.setMapOutputValueClass(IntWritable.class);
			
			job2.setOutputKeyClass(Text.class);
			job2.setOutputValueClass(NullWritable.class);
			
			FileInputFormat.setInputPaths(job2, new Path("hdfs://"+ StaticResource.getIp()+":9000/friend/result"));
			FileOutputFormat.setOutputPath(job2, new Path("hdfs://"+ StaticResource.getIp()+":9000/friend/secresult"));
			
			job2.waitForCompletion(true);
			
		}
		
		
	}
}
