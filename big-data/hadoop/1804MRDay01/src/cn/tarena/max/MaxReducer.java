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
		
		//--迭代器在迭代对象时，底层用到了地址复用技术
		//--地址复用技术好处是可以避免频繁开启内存地址空间
		//--一是可以节省内存，二是可以减轻GC的压力
		for(IntWritable value:values){
			System.err.println(key+":"+value.get());
			if(max.get()<value.get()){
				max=new IntWritable(value.get());
			}
		}
		
		
		context.write(key,max);
	}
}
