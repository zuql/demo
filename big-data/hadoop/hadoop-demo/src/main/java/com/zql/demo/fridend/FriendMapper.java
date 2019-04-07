package com.zql.demo.fridend;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FriendMapper extends Mapper<LongWritable, Text, Text,Text>{
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line=value.toString();
		String name=line.split(" ")[0];
		String friend=line.split(" ")[1];
		
		context.write(new Text(name), new Text(friend));
	}

}
