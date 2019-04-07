package zuql.number.anIntroductionToCase;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;

public class NumberTopology {

	public static void main(String[] args) {
		//--����Storm�Ļ�����������
		Config conf=new Config();

		NumberSpout spout=new NumberSpout();
		PrintBolt printBolt=new PrintBolt();

		//--�������˹����߶���ͨ�����������԰����֮��Ĺ�ϵ
		TopologyBuilder builder=new TopologyBuilder();

		//--������Դ��� �ٲ�:���id,Ҫ��Ψһ�� �������ʵ������
		builder.setSpout("numberSpout", spout);
		//--��Bolt���������ͨ���������������id��������ϵ
		builder.setBolt("printBlot", printBolt)
				.globalGrouping("numberSpout");

		//--�������˶���
		StormTopology topology=builder.createTopology();

		//--Storm�ı������ж��󡣱���ģʽһ�����ڲ���
		LocalCluster cluster=new LocalCluster();

		//--�������ˣ��ٲΣ�����id��Ҫ��Ψһ�� �ڲΣ�storm�Ļ�������
		//--�۲Σ�storm�����˶���
		cluster.submitTopology("numberTopology",conf,topology);
	}

}
