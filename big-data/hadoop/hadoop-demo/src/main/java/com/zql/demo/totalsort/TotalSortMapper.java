package com.zql.demo.totalsort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TotalSortMapper extends Mapper<LongWritable, Text,IntWritable,IntWritable>{

	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, IntWritable, IntWritable>.Context context)
					throws IOException, InterruptedException {
		String line=value.toString();
		String[] nums=line.split(" ");
		for(String num:nums){
			context.write(new IntWritable(Integer.parseInt(num)), 
						  new IntWritable(1));
		}
	}
}
