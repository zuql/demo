package com.zql.demo.average;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * 求平均值
 */
public class AverageDriver {
	
	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job= Job.getInstance(conf);
		
		job.setJarByClass(AverageDriver.class);
		job.setMapperClass(AverageMapper.class);
		job.setReducerClass(AverageReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.setInputPaths(job,
				new Path("hdfs://"+ StaticResource.getIp()+":9000/average"));
		
		FileOutputFormat.setOutputPath(job,
				new Path("hdfs://"+ StaticResource.getIp()+":9000/average/result"));
		
		job.waitForCompletion(true);
	}

}
