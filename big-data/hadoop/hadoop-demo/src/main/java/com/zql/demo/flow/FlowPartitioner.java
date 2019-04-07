package com.zql.demo.flow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * 开发一个自定义的分区器
 * 知识点
 * 1.第一个泛型是Mapper的输出key类型
 * 2.第二个泛型是Mapper的输出value类型
 * 3.分区是有分区编号，从0号开始。如果有三个分区，即：0,1,2
 * @author ysq
 *
 */
public class FlowPartitioner extends Partitioner<Text,Flow> {

	@Override
	public int getPartition(Text key, Flow value, int numPartitions) {
		if(value.getAddr().equals("bj")){
			return 0;
		}
		else if(value.getAddr().equals("sh")){
			return 1;
		}else{
			return 2;
		}
		
		
	}

}
