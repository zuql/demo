package com.zql.demo.score;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ScoreReducer extends Reducer<Text,Student,Student,NullWritable>{

	@Override
	protected void reduce(Text key, Iterable<Student> values, 
			Reducer<Text, Student, Student, NullWritable>.Context context)
			throws IOException, InterruptedException {
		Student result=new Student();
		result.setName(key.toString());
		
		for(Student value:values){
			result.setChinese(result.getChinese()+value.getChinese());
			result.setEnglish(result.getEnglish()+value.getEnglish());
			result.setMath(result.getMath()+value.getMath());
		}
		context.write(result,NullWritable.get());
	}
}
