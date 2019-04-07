package cn.tarena.profit;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ProfitDriver2 {

	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(ProfitDriver2.class);
		job.setMapperClass(ProfitMapper2.class);
	
		
		job.setMapOutputKeyClass(Profit.class);
		job.setMapOutputValueClass(NullWritable.class);
	
		
		FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.150.137:9000/profit/result"));
		FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.150.137:9000/profit/result2"));
		
		job.waitForCompletion(true);
	}
}
