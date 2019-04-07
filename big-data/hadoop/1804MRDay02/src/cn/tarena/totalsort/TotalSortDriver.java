package cn.tarena.totalsort;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;




public class TotalSortDriver {
	
	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(TotalSortDriver.class);
		job.setMapperClass(TotalSortMapper.class);
		job.setReducerClass(TotalSortReducer.class);
		
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setNumReduceTasks(3);
		
		job.setPartitionerClass(TotalPartitioner.class);
		
		FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.150.137:9000/totalsort"));
		FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.150.137:9000/totalsort/result"));
		
		job.waitForCompletion(true);
	}

}
