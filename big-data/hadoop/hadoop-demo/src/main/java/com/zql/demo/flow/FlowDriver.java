package com.zql.demo.flow;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlowDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job= Job.getInstance(conf);
		
		job.setJarByClass(FlowDriver.class);
		job.setMapperClass(FlowMapper.class);
		job.setReducerClass(FlowReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Flow.class);
		
		job.setOutputKeyClass(Flow.class);
		job.setOutputValueClass(NullWritable.class);
		
		//--设置3个分区
		job.setNumReduceTasks(3);
		
		//--设置自定义的分区组件。如果不设定，默认用的是HashPartitioner
		//--默认的分区组件，会按Mapper输出key的hashcode分区，
		//--确保相同的key落到同一个分区里
		job.setPartitionerClass(FlowPartitioner.class);
		
		FileInputFormat.setInputPaths(job,
				new Path("hdfs://"+ StaticResource.getIp()+":9000/flow"));
		
		FileOutputFormat.setOutputPath(job,
				new Path("hdfs://"+ StaticResource.getIp()+":9000/flow/result"));
		
		job.waitForCompletion(true);
	}
}
