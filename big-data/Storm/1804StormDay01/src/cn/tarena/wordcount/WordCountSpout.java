package cn.tarena.wordcount;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class WordCountSpout extends BaseRichSpout{
	
	private SpoutOutputCollector collector;
	
	private String[] lines=new String[]{
			"hello world",
			"hello hadoop",
			"hello world",
			"hello 1804"};
	
	private int index=0;
	
	@Override
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector collector) {
		this.collector=collector;
		
	}
	
	@Override
	public void declareOutputFields(OutputFieldsDeclarer delarer) {
		delarer.declare(new Fields("line"));
		
	}

	@Override
	public void nextTuple() {
		String line=lines[index];
		index++;
		//--在发生tuple时，注意key字段和value字段要对应一致
		collector.emit(new Values(line));
		if(index==lines.length){
			index=0;
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	

}
