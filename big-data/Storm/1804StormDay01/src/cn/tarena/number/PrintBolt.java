package cn.tarena.number;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class PrintBolt extends BaseRichBolt{
	
	//--����Bolt����ķ����������������η���tuple
	private OutputCollector collector;
	
	/*
	 * �˷�����Bolt����ĳ�ʼ������
	 */
	@Override
	public void prepare(Map arg0, TopologyContext arg1, OutputCollector collector) {
		this.collector=collector;
		
	}
	
	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * �˷�����Bolt������ڽ������η�����tuple
	 * ���⣬��������������Ҳ���ڴ˷����з���tuple
	 */
	@Override
	public void execute(Tuple input) {
		//--ͨ��tuple��keyȡֵ
		int number=input.getIntegerByField("number");
	
		
		System.out.println(number);
		
	}

	

	
}
