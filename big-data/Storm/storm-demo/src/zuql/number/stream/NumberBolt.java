package zuql.number.stream;

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
		//--①参：自定义的流id ②参：发生的tuple的key字段
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
