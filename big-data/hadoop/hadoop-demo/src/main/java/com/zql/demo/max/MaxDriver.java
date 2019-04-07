package com.zql.demo.max;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job= Job.getInstance(conf);
		
		job.setJarByClass(MaxDriver.class);
		job.setMapperClass(MaxMapper.class);
		job.setReducerClass(MaxReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.setInputPaths(job,
				new Path("hdfs://"+ StaticResource.getIp()+":9000/max"));
		
		FileOutputFormat.setOutputPath(job,
				new Path("hdfs://"+ StaticResource.getIp()+":9000/max/result"));
		
		job.waitForCompletion(true);
	}
}
