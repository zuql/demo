package zuql.number.anIntroductionToCase;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;

public class NumberTopology {

	public static void main(String[] args) {
		//--创建Storm的环境参数对象
		Config conf=new Config();

		NumberSpout spout=new NumberSpout();
		PrintBolt printBolt=new PrintBolt();

		//--创建拓扑构建者对象，通过这个对象可以绑定组件之间的关系
		TopologyBuilder builder=new TopologyBuilder();

		//--绑定数据源组件 ①参:组件id,要求唯一性 ②组件的实例对象
		builder.setSpout("numberSpout", spout);
		//--绑定Bolt处理组件，通过传入上游组件的id，产生关系
		builder.setBolt("printBlot", printBolt)
				.globalGrouping("numberSpout");

		//--创建拓扑对象
		StormTopology topology=builder.createTopology();

		//--Storm的本地运行对象。本地模式一般用于测试
		LocalCluster cluster=new LocalCluster();

		//--运行拓扑，①参：拓扑id，要求唯一性 ②参：storm的环境对象
		//--③参：storm的拓扑对象
		cluster.submitTopology("numberTopology",conf,topology);
	}

}
