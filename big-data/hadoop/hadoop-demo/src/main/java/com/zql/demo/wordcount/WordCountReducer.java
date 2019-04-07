package com.zql.demo.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * ֪ʶ��
 * 1.��һ���������Ͷ�Ӧ��Mapper�����key����
 * 2.�ڶ����������Ͷ�Ӧ��Mapper�����value����
 * 3.����������������reduce�����key����
 * 4.���ĸ�����������reduce�����value����
 * 5.Reduce������ܵ������ڣ���ΪҪ����Mapper��������
 * 6.Mapper������Ե������ڣ���ֻ��Mapperʱ�����Ľ���ļ���MapTask�����
 * 7.������Mapper����Reduceʱ�����Ľ���ļ���Reduce�������
 * ��Mapper�������Ϊ�м���
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
		//--�����ԣ���һ��reduce�����������key �� Iterable
		context.write(key,new Text(result));
				
	}
}
