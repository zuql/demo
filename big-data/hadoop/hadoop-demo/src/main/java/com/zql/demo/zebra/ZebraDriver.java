package com.zql.demo.zebra;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ZebraDriver {
	
	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(ZebraDriver.class);
		job.setMapperClass(ZebraMapper.class);
		job.setReducerClass(ZebraReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(HttpAppHost.class);
		
		job.setOutputKeyClass(HttpAppHost.class);
		job.setOutputValueClass(NullWritable.class);
		
		FileInputFormat.setInputPaths(job,new Path("hdfs://"+ StaticResource.getIp() +":9000/zebra"));
		FileOutputFormat.setOutputPath(job,new Path("hdfs://"+ StaticResource.getIp() +":9000/zebra/result"));
		
		job.waitForCompletion(true);
	}

}
