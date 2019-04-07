package com.zql.demo.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer1 extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
                          Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		int result=0;
		
		for(IntWritable value:values){
			result=result+value.get();
		}
		context.write(key,new IntWritable(result));
	}
}
