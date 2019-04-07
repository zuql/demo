package cn.tarena.trident;

import backtype.storm.tuple.Values;
import storm.trident.operation.BaseAggregator;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

/*
 * Aggregator聚合器，输出的tuple可以有一个或多个Key字段
 * 泛型定义的是init()方法的返回值类型。所以泛型可以不按业务合并的字段指定
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
