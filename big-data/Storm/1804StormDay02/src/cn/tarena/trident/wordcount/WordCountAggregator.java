package cn.tarena.trident.wordcount;

import java.util.HashMap;
import java.util.Map;

import backtype.storm.tuple.Values;
import storm.trident.operation.BaseAggregator;
import storm.trident.operation.TridentCollector;
import storm.trident.operation.TridentOperationContext;
import storm.trident.tuple.TridentTuple;

public class WordCountAggregator extends BaseAggregator<String>{
	//--创建Trident框架的上下文件对象
	private TridentOperationContext context;
	
	@Override
	public void prepare(Map conf, TridentOperationContext context) {
		//--初始化上下文对象
	   this.context=context;
	}
	
	private Map<String, Integer> map=new HashMap<>();

	@Override
	public String init(Object batchId, TridentCollector collector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggregate(String val, TridentTuple tuple, TridentCollector collector) {
		String word=tuple.getStringByField("word");
		System.err.println("分区编号:"+context.getPartitionIndex()+"word:"+word);
		if(map.containsKey(word)){
			map.put(word, map.get(word)+1);
		}else{
			map.put(word, 1);
		}
		collector.emit(new Values(word,map.get(word)));
		
	}

	@Override
	public void complete(String val, TridentCollector collector) {
		// TODO Auto-generated method stub
		
	}

}
