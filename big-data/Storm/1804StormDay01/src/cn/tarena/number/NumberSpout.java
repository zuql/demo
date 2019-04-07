package cn.tarena.number;

import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

/**
 * ����һ��Spout(����Դ)���
 * �����У�������Դ�������ǲ���һ��һ����������֣������ε�bolt����
 * @author ysq
 *
 */
public class NumberSpout extends BaseRichSpout{
	
	//--����Դ�ķ�������ͨ����������tuple���������
	private SpoutOutputCollector collector;
	
	/*
	 * �˷����ǳ�ʼ�����������Դ˷�����������ĳ�ʼ��
	 */
	@Override
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector collector) {
		this.collector=collector;
		
	}
	
	/*
	 * �˷����������������η����tuple��key�ֶ�����
	 */
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		//--ͨ��Fields������tuple��key�ֶΣ������ж��
		declarer.declare(new Fields("number"));
		
	}
	
	/*
	 * �˷������ڲ������ݣ��������η���tuple
	 * �˷����ᱻ���ö�Σ�ע�⣺��Ҫ���˷�����Ϊ��������
	 */
	@Override
	public void nextTuple() {
		//--����һ��100�ڵ������
		int number=new Random().nextInt(100);
		//--�����ַ�װ��tuple�Ȼ��ͨ��������������ȥ
		collector.emit(new Values(number));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

	

}
