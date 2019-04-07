package com.zql.demo.yesun;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class YesunReducer extends Reducer<Text,Text,Text,NullWritable>{

	@Override
	protected void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		ArrayList<String> grandpaList=new ArrayList<>();
		ArrayList<String> grandsonList=new ArrayList<>();
		
		for(Text value:values){
			if(value.toString().startsWith("+")){
				grandpaList.add(value.toString().substring(1));
			}else{
				grandsonList.add(value.toString().substring(1));
			}
		}
		if(grandpaList.size()>0&&grandsonList.size()>0){
			String grandpa=grandpaList.toString();
			String grandson=grandsonList.toString();
			
			String relation="үү��:"+grandpa+"-->���ӱ�:"+grandson;
			
			context.write(new Text(relation),NullWritable.get());
		}
		
		
	}
}
