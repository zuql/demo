package cn.tedu.flux;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

public class PrintBolt extends BaseRichBolt{
	private OutputCollector collector = null;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		try {
			//1.获取输入tuple中所有键
			Fields fields = input.getFields();
			//2.遍历打印所有键值
			for(String key : fields){
				Object value = input.getValueByField(key);
				System.out.println(key + "~" + value);
			}
			collector.ack(input);
		} catch (Exception e) {
			collector.fail(input);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

}
