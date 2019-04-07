package cn.tarena.number.stream;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;

public class NumberStreamTopology {

	public static void main(String[] args) {
		Config conf=new Config();
		NumberSpout spout=new NumberSpout();
		NumberBolt numberBolt=new NumberBolt();
		LessThanBolt lessThanBolt=new LessThanBolt();
		MoreThanBolt moreThanBolt=new MoreThanBolt();
		
		TopologyBuilder builder=new TopologyBuilder();
		
		builder.setSpout("numberSpout", spout);
		builder.setBolt("numberBolt", numberBolt)
			   .shuffleGrouping("numberSpout");
		
		
		builder.setBolt("lessThanBolt",lessThanBolt)
				//--�Զ��������飬�ٲΣ��������id �ڲ�:�Զ������id
			   .globalGrouping("numberBolt","lessThan");
		
		builder.setBolt("moreThanBolt",moreThanBolt)
		       .globalGrouping("numberBolt","moreThan");
		
		StormTopology topology=builder.createTopology();
		
		LocalCluster cluster=new LocalCluster();
		
		cluster.submitTopology("numberTopology",conf,topology);
		
		
	}
}
