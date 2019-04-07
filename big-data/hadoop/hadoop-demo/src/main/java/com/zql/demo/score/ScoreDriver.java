package com.zql.demo.score;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ScoreDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(ScoreDriver.class);
		job.setMapperClass(ScoreMapper.class);
		job.setReducerClass(ScoreReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Student.class);
		
		job.setOutputKeyClass(Student.class);
		job.setOutputValueClass(NullWritable.class);
		
		FileInputFormat.setInputPaths(job,new Path("hdfs://" + StaticResource.getIp() + ":9000/score"));
		FileOutputFormat.setOutputPath(job,new Path("hdfs://" + StaticResource.getIp() + ":9000/score/result"));
		
		job.waitForCompletion(true);
	}
}
