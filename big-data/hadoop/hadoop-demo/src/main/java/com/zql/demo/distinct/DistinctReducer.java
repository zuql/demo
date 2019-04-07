package com.zql.demo.distinct;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class DistinctReducer extends Reducer<Text, NullWritable, Text, NullWritable> {

	@Override
	protected void reduce(Text key, Iterable<NullWritable> values,
                          Reducer<Text, NullWritable, Text, NullWritable>.Context context) throws IOException, InterruptedException {
		
		context.write(key, NullWritable.get());
	}
}
