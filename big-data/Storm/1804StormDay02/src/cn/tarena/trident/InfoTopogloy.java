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
		
		//--����Trident����ṩ������Դ��������������Tuple��
		//--�ٲΣ�����tuple��key�ֶ�  �ڲ�:����С �۲Σ�������tuple��ֵ
		FixedBatchSpout spout=new FixedBatchSpout(
				new Fields("name","age"),2,
				new Values("tom",23),
				new Values("rose",25),
				new Values("jary",28),
				new Values("jim",35));
		
		//--����ѭ����������
		//spout.setCycle(true);
		
		//--��ȡTrident��ܵ����˹�����
		TridentTopology topology=new TridentTopology();
		//--������Դ
//		topology.newStream("spout", spout)
//				//--��������������ÿ��Ը��ݹ������������˳���ص�tuple�������з���
//				.each(new Fields("name","age"),new NameFilter())
//				//--Function��������Ի��������tuple��׷���µ��ֶβ����䵽����
//				.each(new Fields("name","age"),new GenderFunction(),new Fields("gender"))
//				.each(new Fields("name","age","gender"),new PrintFilter());
		
		topology.newStream("spout", spout)
				//--�������ϲ����ۺϣ�
				.partitionAggregate(new Fields("name","age")
						           ,new AgeAggregator()
						           ,new Fields("info","ageSum"))
				.each(new Fields("info","ageSum"),new PrintFilter());
		
		
		LocalCluster cluster=new LocalCluster();
		
		cluster.submitTopology("infoTopology",config,topology.build());
	}

}
