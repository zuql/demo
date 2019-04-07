package zuql.wordcount;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import cn.tarena.wordcount.WordCountBolt;


public class WordCountTopology {

	public static void main(String[] args) throws Exception {
		Config conf=new Config();

		//--设置当前拓扑的进程并发度，默认是1个
		conf.setNumWorkers(2);

		WordCountSpout spout=new WordCountSpout();
		SplitBolt splitBolt=new SplitBolt();
		WordCountBolt wordCountBolt=new WordCountBolt();
		PrintBolt printBolt=new PrintBolt();

		TopologyBuilder builder=new TopologyBuilder();

		//--设置组件的线程并发度和Task并发度,如果线程的并发度=Task的并发度
		//--则setNumTasks()可以省略，因为这种情况：一个线程运行一个Task
		builder.setSpout("wordcountSpout", spout);

		builder.setBolt("splitBolt", splitBolt,2).setNumTasks(4)
				//--随机数据流分组。
				.shuffleGrouping("wordcountSpout");

		builder.setBolt("wordcountBolt", wordCountBolt,2).setNumTasks(2)
				//--字段数据流分组，确保代码中指定的key字段对应的值，
				//--相同的值落到同一个Bolt里
				.fieldsGrouping("splitBolt",new Fields("word"));

		builder.setBolt("printBolt", printBolt)
				//--全局分组,会将所有数据汇聚到一个Bolt上
				.globalGrouping("wordcountBolt");

		StormTopology topology=builder.createTopology();

		//--本地集群模式
		LocalCluster cluster=new LocalCluster();
		cluster.submitTopology("wordCountTopology",conf,topology);

		//--集群模式的提交
		/*StormSubmitter cluster=new StormSubmitter();
		cluster.submitTopology("wordCountTopology",conf, topology);*/
	}
}
