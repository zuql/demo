package com.zql.demo.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * 知识点
 * 1.第一个泛型类型对应的Mapper的输出key类型
 * 2.第二个泛型类型对应的Mapper的输出value类型
 * 3.第三个泛型类型是reduce的输出key类型
 * 4.第四个泛型类型是reduce的输出value类型
 * 5.Reduce组件不能单独存在，因为要接受Mapper组件的输出
 * 6.Mapper组件可以单独存在，当只有Mapper时，最后的结果文件是MapTask的输出
 * 7.当既有Mapper又有Reduce时，最后的结果文件是Reduce的输出。
 * 而Mapper的输出做为中间结果
 * @author ysq
 *
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
                          Reducer<Text, IntWritable, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String result="";
		for(IntWritable value:values){
			result=result+","+value.get();
		}
		//--做测试，看一下reduce组件传进来的key 和 Iterable
		context.write(key,new Text(result));
				
	}
}
