package com.zql.demo.score;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class ScoreMapper extends Mapper<LongWritable,Text,Text,Student>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Student>.Context context)
			throws IOException, InterruptedException {
		//--  1 zhang 89
		String line=value.toString();
		String name=line.split(" ")[1];
		int score=Integer.parseInt(line.split(" ")[2]);
		
		Student s=new Student();
		s.setName(name);
		//--如果知道当前的分数是哪一科分数
		//--可以通过获取当前MapTask处理的切片信息来获取文件名
		FileSplit split=(FileSplit) context.getInputSplit();
		//--获取文件名
		String fileName=split.getPath().getName();
		
		if(fileName.equals("chinese.txt")){
			s.setChinese(score);
		}else if(fileName.equals("english.txt")){
			s.setEnglish(score);
		}else{
			s.setMath(score);
		}
		
		context.write(new Text(name),s);
	}
}
