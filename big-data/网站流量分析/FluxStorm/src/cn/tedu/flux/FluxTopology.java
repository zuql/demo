package cn.tedu.flux;

import java.util.UUID;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;
import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.StringScheme;
import storm.kafka.ZkHosts;

public class FluxTopology {
	public static void main(String[] args) throws Exception {
		//1.构建组件
		BrokerHosts hosts = new ZkHosts("hadoop02:2181,hadoop01:2181,hadoop03:2181");
		SpoutConfig spoutConfig = new SpoutConfig(hosts, "fluxTopic", "/fluxTopic" , UUID.randomUUID().toString());
		spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
		KafkaSpout spout = new KafkaSpout(spoutConfig);

		ClearBolt clearBolt = new ClearBolt();
		PvBolt pvBolt = new PvBolt();
		UvBolt uvBolt = new UvBolt();
		ToHBaseBolt toHBaseBolt = new ToHBaseBolt();
		PrintBolt printBolt = new PrintBolt();

		//2.创建拓扑构建者
		TopologyBuilder builder = new TopologyBuilder();

		//3.描述拓扑结构
		builder.setSpout("Flux_Kafka_Spout", spout);
		builder.setBolt("ClearBolt", clearBolt).shuffleGrouping("Flux_Kafka_Spout");
		builder.setBolt("Pv_Bolt", pvBolt).shuffleGrouping("ClearBolt");
		builder.setBolt("Uv_Bolt", uvBolt).shuffleGrouping("Pv_Bolt");
		builder.setBolt("To_HBase_Bolt", toHBaseBolt).shuffleGrouping("Uv_Bolt");
		builder.setBolt("Print_Bolt", printBolt).shuffleGrouping("Uv_Bolt");
		//builder.setBolt("Print_Bolt", printBolt).shuffleGrouping("Flux_Kafka_Spout");
		//4.创建拓扑
		StormTopology topology = builder.createTopology();

		//5.提交拓扑运行
//		Config conf = new Config();
//		StormSubmitter.submitTopology("Flux_Topology", conf, topology);

		LocalCluster cluster = new LocalCluster();
		Config conf = new Config();
		cluster.submitTopology("Flux_Topology", conf, topology);
	}
}
