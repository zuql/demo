package com.zql.demo.flow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * ����һ���Զ���ķ�����
 * ֪ʶ��
 * 1.��һ��������Mapper�����key����
 * 2.�ڶ���������Mapper�����value����
 * 3.�������з�����ţ���0�ſ�ʼ���������������������0,1,2
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
