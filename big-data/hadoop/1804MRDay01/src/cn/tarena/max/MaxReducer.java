package cn.tarena.max;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxReducer extends Reducer<Text,IntWritable,Text,IntWritable>{

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		IntWritable max=new IntWritable(0);
		
		//--�������ڵ�������ʱ���ײ��õ��˵�ַ���ü���
		//--��ַ���ü����ô��ǿ��Ա���Ƶ�������ڴ��ַ�ռ�
		//--һ�ǿ��Խ�ʡ�ڴ棬���ǿ��Լ���GC��ѹ��
		for(IntWritable value:values){
			System.err.println(key+":"+value.get());
			if(max.get()<value.get()){
				max=new IntWritable(value.get());
			}
		}
		
		
		context.write(key,max);
	}
}
