package com.zql.demo.average;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AverageMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String line=value.toString();
		String name=line.split(" ")[0];
		int score=Integer.parseInt(line.split(" ")[1]);
		
		context.write(new Text(name), new IntWritable(score));
	}
}
