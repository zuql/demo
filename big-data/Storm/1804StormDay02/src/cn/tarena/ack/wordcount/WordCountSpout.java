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
		//--Storm at least once(����һ������),
		//--����Դ�ڷ���tupleʱҪ����һ��ȫ��Ψһ��id
		map.put(msgId,new Values(line));
		
		collector.emit(new Values(line), msgId);
		if(index==lines.length){
			index=0;
		}
		
	}
	@Override
	public void ack(Object msgId) {
		//--���tuple����ɹ���һ����map���Ƴ���
		//--������ܻ�����ڴ����
		map.remove(msgId);
	}
	/*
	 * �����ε��������failʱ�������˷�����
	 * ������Ҫ����ʧ��tuple��id,���·���һ��
	 */
	@Override
	public void fail(Object msgId) {
		collector.emit(map.get(msgId), msgId);
	}

	

	

}
