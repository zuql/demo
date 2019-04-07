package cn.tarena.number.stream;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class NumberBolt extends BaseRichBolt{
	
	private OutputCollector collector;
	
	@Override
	public void prepare(Map arg0, TopologyContext arg1, OutputCollector collector) {
		this.collector=collector;
		
	}
	
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		//--�ٲΣ��Զ������id �ڲΣ�������tuple��key�ֶ�
		declarer.declareStream("lessThan",new Fields("number"));
		declarer.declareStream("moreThan",new Fields("number"));
		
	}

	@Override
	public void execute(Tuple input) {
		int  number=input.getIntegerByField("number");
		if(number<50){
			collector.emit("lessThan",new Values(number));
		}else{
			collector.emit("moreThan",new Values(number));
		}
		
	}

	

	

}
