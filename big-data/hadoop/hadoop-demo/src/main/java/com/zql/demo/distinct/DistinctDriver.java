package com.zql.demo.distinct;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DistinctDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job= Job.getInstance(conf);
		
		job.setJarByClass(DistinctDriver.class);
		job.setMapperClass(DistinctMapper.class);
		job.setReducerClass(DistinctReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(NullWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);
		
		FileInputFormat.setInputPaths(job,
				new Path("hdfs://"+ StaticResource.getIp()+":9000/distinct"));
		
		FileOutputFormat.setOutputPath(job,
				new Path("hdfs://"+ StaticResource.getIp()+":9000/distinct/result"));
		
		job.waitForCompletion(true);
	}
}
