package com.zql.demo.multipleinput;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ScoreMapper2 extends Mapper<Text,Text,Text,Text>{

	@Override
	protected void map(Text key, Text value, Mapper<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		context.write(key, value);
	}
}
