package com.zql.demo.join;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class JoinMapper extends Mapper<LongWritable,Text,Text,Item>{

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line=value.toString();
		String[] infos=line.split(" ");
		Item item=new Item();
		FileSplit split=(FileSplit) context.getInputSplit();
		

		
		if(split.getPath().getName().startsWith("order")){
			item.setId(infos[0]);
			item.setDate(infos[1]);
			item.setPid(infos[2]);
			item.setAmount(Integer.parseInt(infos[3]));
			
		}else{
			item.setPid(infos[0]);
			item.setName(infos[1]);
			item.setPrice(Double.parseDouble(infos[2]));
		
			
		}
		context.write(new Text(item.getPid()),item);
			
	}
}
