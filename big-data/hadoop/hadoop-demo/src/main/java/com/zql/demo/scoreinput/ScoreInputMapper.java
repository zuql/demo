package com.zql.demo.scoreinput;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ScoreInputMapper extends Mapper<Text,Text,Text,Text>{

	@Override
	protected void map(Text key, Text value, Mapper<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(key, value);
	}
}
