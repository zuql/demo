package cn.tarena.trident;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import storm.trident.TridentTopology;
import storm.trident.testing.FixedBatchSpout;

public class InfoTopogloy {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Config config=new Config();
		
		//--利用Trident框架提供的数据源，可以批量发送Tuple。
		//--①参：发生tuple的key字段  ②参:批大小 ③参：发生的tuple的值
		FixedBatchSpout spout=new FixedBatchSpout(
				new Fields("name","age"),2,
				new Values("tom",23),
				new Values("rose",25),
				new Values("jary",28),
				new Values("jim",35));
		
		//--设置循环发送数据
		//spout.setCycle(true);
		
		//--获取Trident框架的拓扑构建者
		TridentTopology topology=new TridentTopology();
		//--绑定数据源
//		topology.newStream("spout", spout)
//				//--过滤器组件的作用可以根据过滤条件，过滤出相关的tuple，不进行发送
//				.each(new Fields("name","age"),new NameFilter())
//				//--Function组件，可以基于输入的tuple，追加新的字段并发射到下游
//				.each(new Fields("name","age"),new GenderFunction(),new Fields("gender"))
//				.each(new Fields("name","age","gender"),new PrintFilter());
		
		topology.newStream("spout", spout)
				//--按批来合并（聚合）
				.partitionAggregate(new Fields("name","age")
						           ,new AgeAggregator()
						           ,new Fields("info","ageSum"))
				.each(new Fields("info","ageSum"),new PrintFilter());
		
		
		LocalCluster cluster=new LocalCluster();
		
		cluster.submitTopology("infoTopology",config,topology.build());
	}

}
