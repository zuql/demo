package zuql.wordcount;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.HashMap;
import java.util.Map;

public class WordCountBolt extends BaseRichBolt {
	
	private OutputCollector collector;
	
	private Map<String,Integer> map=new HashMap<>();
	
	
	@Override
	public void prepare(Map arg0, TopologyContext arg1, OutputCollector collector) {
		this.collector=collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("word","count"));
		
	}
	@Override
	public void execute(Tuple input) {
		String word=input.getStringByField("word");
		
		if(map.containsKey(word)){
			map.put(word,map.get(word)+1);
		}else{
			map.put(word,1);
		}
		//--Tuple是kv对的集合，可以有一个，也可以有多个。
		//--注意：key和value的数量以及对应关系保持一致
		collector.emit(new Values(word,map.get(word)));
		
	}

	

	

}
