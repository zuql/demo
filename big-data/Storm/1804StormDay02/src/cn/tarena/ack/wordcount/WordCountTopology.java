package cn.tarena.ack.wordcount;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

public class WordCountTopology {

	public static void main(String[] args) {
		Config conf=new Config();
		WordCountSpout spout=new WordCountSpout();
		SplitBolt splitBolt=new SplitBolt();
		WordCountBolt wordcountBolt=new WordCountBolt();
		PrintBolt printBolt=new PrintBolt();
		
		TopologyBuilder builder=new TopologyBuilder();
		
		builder.setSpout("spout", spout);
		builder.setBolt("splitBolt", splitBolt).shuffleGrouping("spout");
		builder.setBolt("wordcountBolt",wordcountBolt).fieldsGrouping("splitBolt",new Fields("word"));
		builder.setBolt("printBolt", printBolt).globalGrouping("wordcountBolt");
		
		StormTopology topology=builder.createTopology();
		
		LocalCluster cluster=new LocalCluster();
		cluster.submitTopology("wordcountTopology", conf, topology);
	}
}
