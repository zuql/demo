package com.zql.demo.average;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class AverageReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
                          Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		int result=0;
		int count=0;
		for(IntWritable value:values){
			result=result+value.get();
			count++;
		}
		int average=result/count;
		
		context.write(key,new IntWritable(average));
				
	}
}
