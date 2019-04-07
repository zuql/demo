package cn.tarena.ack.wordcount;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.Validate;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class WordCountBolt extends BaseRichBolt{
	
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
		try {
			String word=input.getStringByField("word");
			if(map.containsKey(word)){
				map.put(word, map.get(word)+1);
			}else{
				map.put(word, 1);
			}
			collector.emit(input,new Values(word,map.get(word)));
			collector.ack(input);
		} catch (Exception e) {
			collector.fail(input);
		}
		
		
		
	}



	

}
