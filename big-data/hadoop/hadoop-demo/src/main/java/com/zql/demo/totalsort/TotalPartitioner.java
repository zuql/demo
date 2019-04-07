package com.zql.demo.totalsort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class TotalPartitioner extends Partitioner<IntWritable,IntWritable>{

	@Override
	public int getPartition(IntWritable key, IntWritable value, int numPartitions) {
		if(key.get()<100){
			return 0;
		}else if(key.get()<1000){
			return 1;
		}else{
			return 2;
		}
		
	}

}
