package com.zql.demo.invert;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class InvertMapper2 extends Mapper<LongWritable,Text,Text,Text>{

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line=value.toString();
		String word=line.split("\\|")[0];
		String FileInfo=line.split("\\|")[1];
		
		context.write(new Text(word), new Text(FileInfo));
	}
}
