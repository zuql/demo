package cn.tedu.flux;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;
import cn.tedu.flux.domain.FluxInfo;
import cn.tedu.flux.utils.HBaseUtils;

public class ToHBaseBolt extends BaseRichBolt{
	private OutputCollector collector = null;
	
	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		try {
			FluxInfo fi = new FluxInfo();
			fi.setUrl(input.getStringByField("url"));
			fi.setUrlname(input.getStringByField("urlname"));
			fi.setRef(input.getStringByField("ref"));
			fi.setUagent(input.getStringByField("uagent"));
			fi.setUvid(input.getStringByField("uvid"));
			fi.setSsid(input.getStringByField("ssid"));
			fi.setSscount(input.getStringByField("sscount"));
			fi.setSstime(input.getStringByField("sstime"));
			fi.setCip(input.getStringByField("cip"));
			
			HBaseUtils.putToHBase("flux", fi);
			
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
