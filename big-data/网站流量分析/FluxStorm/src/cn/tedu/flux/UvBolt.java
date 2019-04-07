package cn.tedu.flux;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import cn.tedu.flux.domain.FluxInfo;
import cn.tedu.flux.utils.HBaseUtils;

public class UvBolt extends BaseRichBolt{

	private OutputCollector collector = null;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		try {
			//1.获取当前日志的uvid
			String uvid = input.getStringByField("uvid");
			//2.检查此uvid在今天这条日志之前是否出现过
			long now = Long.parseLong(input.getStringByField("sstime"));
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(now);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND,0);
			long zero = calendar.getTimeInMillis();
			List<FluxInfo> list = HBaseUtils.queryFromHBase("flux", (zero+"").getBytes(), (now+"").getBytes(), "^[^_]*_"+uvid+"_.*$");
			//3.uvid = 是否出现 ? 0 : 1
			int uv =  list.size() == 0 ? 1 : 0;
			//4.发送tuple
			List<Object> values = input.getValues();
			values.add(uv);
			collector.emit(input,values);
			collector.ack(input);
		} catch (Exception e) {
			collector.fail(input);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("url","urlname","ref","uagent","uvid","ssid","sscount","sstime","cip","pv","uv"));
	}

}
