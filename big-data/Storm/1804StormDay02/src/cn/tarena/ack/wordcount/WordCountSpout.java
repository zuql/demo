package cn.tarena.ack.wordcount;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class WordCountSpout extends BaseRichSpout{
	
	private SpoutOutputCollector collector;
	String[] lines=new String[]{"hello world","hello hadoop","hello 1804"};
	int index=0;
	private Map<UUID,Values> map;

	@Override
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector collector) {
		this.collector=collector;
		
		map=new HashMap<>();
	}
	
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("line"));
		
	}
	@Override
	public void nextTuple() {
		String line=lines[index];
		index++;
		UUID msgId=UUID.randomUUID();
		//--Storm at least once(至少一次语义),
		//--数据源在发射tuple时要跟上一个全局唯一的id
		map.put(msgId,new Values(line));
		
		collector.emit(new Values(line), msgId);
		if(index==lines.length){
			index=0;
		}
		
	}
	@Override
	public void ack(Object msgId) {
		//--如果tuple处理成功，一定从map里移除。
		//--否则可能会造成内存溢出
		map.remove(msgId);
	}
	/*
	 * 当下游的组件反馈fail时，会进入此方法。
	 * 我们需要根据失败tuple的id,重新发射一次
	 */
	@Override
	public void fail(Object msgId) {
		collector.emit(map.get(msgId), msgId);
	}

	

	

}
