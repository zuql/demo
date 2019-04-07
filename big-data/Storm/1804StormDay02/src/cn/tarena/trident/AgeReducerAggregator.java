package cn.tarena.trident;

import storm.trident.operation.ReducerAggregator;
import storm.trident.tuple.TridentTuple;

public class AgeReducerAggregator implements ReducerAggregator<Integer>{

	/*
	 * �˷���������ĳ�ʼ�������������curr��������reduce����
	 */
	@Override
	public Integer init() {
	
		return 0;
	}
	
	//--curr=0 age=23 ageSum=23
	//--curr=23 age=25 ageSum=48
	@Override
	public Integer reduce(Integer curr, TridentTuple tuple) {
		int age=tuple.getIntegerByField("age");
		int ageSum=curr+age;
		return ageSum;
	}

}
