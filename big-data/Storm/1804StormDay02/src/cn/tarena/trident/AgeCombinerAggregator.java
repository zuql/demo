package cn.tarena.trident;

import storm.trident.operation.CombinerAggregator;
import storm.trident.tuple.TridentTuple;

public class AgeCombinerAggregator 
					implements CombinerAggregator<Integer>{
	/*
	 * �˷���������ĳ�ʼ���������˷����᷵��һ����ʼֵ val1,
	 * val1�ᴫ��combine����
	 */
	@Override
	public Integer zero() {
		
		return 0;
	}
	/*
	 * �˷�����������η�����tuple
	 * �˷����᷵��val2ֵ������combine����
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
