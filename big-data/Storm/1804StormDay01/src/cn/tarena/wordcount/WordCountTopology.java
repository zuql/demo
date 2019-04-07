package cn.tarena.wordcount;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

public class WordCountTopology {

	public static void main(String[] args) throws Exception {
		Config conf=new Config();
		
		//--���õ�ǰ���˵Ľ��̲����ȣ�Ĭ����1��
		conf.setNumWorkers(2);
		
		WordCountSpout spout=new WordCountSpout();
		SplitBolt splitBolt=new SplitBolt();
		WordCountBolt wordCountBolt=new WordCountBolt();
		PrintBolt printBolt=new PrintBolt();
		
		TopologyBuilder builder=new TopologyBuilder();
		
		//--����������̲߳����Ⱥ�Task������,����̵߳Ĳ�����=Task�Ĳ�����
		//--��setNumTasks()����ʡ�ԣ���Ϊ���������һ���߳�����һ��Task
		builder.setSpout("wordcountSpout", spout);
		
		builder.setBolt("splitBolt", splitBolt,2).setNumTasks(4)
				//--������������顣
			   .shuffleGrouping("wordcountSpout");
		
		builder.setBolt("wordcountBolt", wordCountBolt,2).setNumTasks(2)
				//--�ֶ����������飬ȷ��������ָ����key�ֶζ�Ӧ��ֵ��
				//--��ͬ��ֵ�䵽ͬһ��Bolt��
		       .fieldsGrouping("splitBolt",new Fields("word"));
		
		builder.setBolt("printBolt", printBolt)
				//--ȫ�ַ���,�Ὣ�������ݻ�۵�һ��Bolt��
			   .globalGrouping("wordcountBolt");
		
		StormTopology topology=builder.createTopology();
		
		//--���ؼ�Ⱥģʽ
		//LocalCluster cluster=new LocalCluster();
		//cluster.submitTopology("wordCountTopology",conf,topology);
		
		//--��Ⱥģʽ���ύ
		StormSubmitter cluster=new StormSubmitter();
		cluster.submitTopology("wordCountTopology",conf, topology);
	}
}
