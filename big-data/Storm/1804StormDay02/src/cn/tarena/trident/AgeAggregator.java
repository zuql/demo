package cn.tarena.trident;

import backtype.storm.tuple.Values;
import storm.trident.operation.BaseAggregator;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

/*
 * Aggregator�ۺ����������tuple������һ������Key�ֶ�
 * ���Ͷ������init()�����ķ���ֵ���͡����Է��Ϳ��Բ���ҵ��ϲ����ֶ�ָ��
 */
public class AgeAggregator extends BaseAggregator<Integer>{
	
	private int ageSum=0;

	@Override
	public Integer init(Object batchId, TridentCollector collector) {
		
		return 0;
	}

	@Override
	public void aggregate(Integer val, TridentTuple tuple, TridentCollector collector) {
		int age=tuple.getIntegerByField("age");
		ageSum=ageSum+age;
		collector.emit(new Values("aaa",ageSum));
		
		
	}

	@Override
	public void complete(Integer val, TridentCollector collector) {
		// TODO Auto-generated method stub
		
	}

}
