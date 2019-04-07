package cn.tarena.trident.wordcount;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.tuple.Fields;
import cn.tarena.trident.PrintFilter;
import storm.trident.TridentTopology;

public class WordCountTopology {
	
	public static void main(String[] args) {
		Config config=new Config();
		WordCountSpout spout=new WordCountSpout();
		
		TridentTopology topology=new TridentTopology();
		
		        topology.newStream("spout", spout)
		        //--随机重分区操作
		        .shuffle()
				//--切分组件
				.partitionAggregate(new Fields("line"),
						            new SplitAggregator(),
						            new Fields("word"))
				.parallelismHint(3)
				//--字段重分区操作
				.partitionBy(new Fields("word"))
				//--单词频次组件
				.partitionAggregate(new Fields("word"),
			            new WordCountAggregator(),
			            new Fields("word","count"))
				.parallelismHint(2);
				//--全局分区操作
//				.global()
//				//--打印组件
//				.each(new Fields("word","count"),new PrintFilter())
//				.parallelismHint(1);
		
		LocalCluster cluster=new LocalCluster();
		cluster.submitTopology("topology",config,topology.build());
	}

}
