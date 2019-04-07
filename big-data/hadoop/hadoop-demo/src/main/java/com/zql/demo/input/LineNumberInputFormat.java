package com.zql.demo.input;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;

/**
 * 自定义格式输入组件，决定Mapper的输入key和输入value类型
 * 第一个泛型：Mapper的输入key
 * 第二个泛型：Mapper的输入value
 * @author ysq
 *
 */
public class LineNumberInputFormat 
	extends FileInputFormat<IntWritable,Text>{

	@Override
	public RecordReader<IntWritable, Text> createRecordReader(InputSplit split, TaskAttemptContext context)
			throws IOException, InterruptedException {

		return new LineNumberRecordReader();
	}

}
