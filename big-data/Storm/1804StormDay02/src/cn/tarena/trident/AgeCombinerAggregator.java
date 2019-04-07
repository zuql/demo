package cn.tarena.trident;

import storm.trident.operation.CombinerAggregator;
import storm.trident.tuple.TridentTuple;

public class AgeCombinerAggregator 
					implements CombinerAggregator<Integer>{
	/*
	 * 此方法是组件的初始化方法，此方法会返回一个初始值 val1,
	 * val1会传给combine方法
	 */
	@Override
	public Integer zero() {
		
		return 0;
	}
	/*
	 * 此方法会接收上游发来的tuple
	 * 此方法会返回val2值，传给combine方法
	 */
	@Override
	public Integer init(TridentTuple tuple) {
		int age=tuple.getIntegerByField("age");
		return age;
	}
	//--val1=0 val2=23 ageSum=23
	//--val1=23 val2=25 ageSum=48
	//--val1=48 val2=28
	@Override
	public Integer combine(Integer val1, Integer val2) {

		int ageSum=val1+val2;
		return ageSum;
	}

	

}
