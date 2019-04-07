package com.zql.demo.flow;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlowDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job= Job.getInstance(conf);
		
		job.setJarByClass(FlowDriver.class);
		job.setMapperClass(FlowMapper.class);
		job.setReducerClass(FlowReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Flow.class);
		
		job.setOutputKeyClass(Flow.class);
		job.setOutputValueClass(NullWritable.class);
		
		//--����3������
		job.setNumReduceTasks(3);
		
		//--�����Զ���ķ��������������趨��Ĭ���õ���HashPartitioner
		//--Ĭ�ϵķ���������ᰴMapper���key��hashcode������
		//--ȷ����ͬ��key�䵽ͬһ��������
		job.setPartitionerClass(FlowPartitioner.class);
		
		FileInputFormat.setInputPaths(job,
				new Path("hdfs://"+ StaticResource.getIp()+":9000/flow"));
		
		FileOutputFormat.setOutputPath(job,
				new Path("hdfs://"+ StaticResource.getIp()+":9000/flow/result"));
		
		job.waitForCompletion(true);
	}
}
