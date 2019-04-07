package cn.tarena;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.junit.Test;

public class TestDemo {
	
	@Test
	public void createTable() throws Exception{
		//--��ȡhbase�Ļ���������������
		Configuration conf=HBaseConfiguration.create();
		
		//--����zk��Ⱥ���ӵ�ַ������ֻдһ��
		conf.set("hbase.zookeeper.quorum",
				"192.168.150.137:2181,"
				+ "192.168.150.138:2181,"
				+ "192.168.150.139:2181");
		
		HBaseAdmin admin=new HBaseAdmin(conf);
		
		//--����HBase����󣬲�ָ������
		HTableDescriptor table=new HTableDescriptor("tab1");
		//--����HBase����������
		HColumnDescriptor cf1=new HColumnDescriptor("cf1");
		HColumnDescriptor cf2=new HColumnDescriptor("cf2");
		
		//--ָ��ĳ�������cell��ౣ������ʷ�汾����Ĭ����3
		cf1.setMaxVersions(3);
		//--������ͱ�����󶨹�ϵ
		table.addFamily(cf1);
		table.addFamily(cf2);
		
		//--ִ�н���
		admin.createTable(table);
		
		admin.close();
	}
	@Test
	public void putdata() throws Exception{
		Configuration conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum",
				"192.168.150.137:2181,"
				+ "192.168.150.138:2181,"
				+ "192.168.150.139:2181");
		
		//--����Ҫ�����ı����
		HTable table=new HTable(conf,"tab1");
		//--��ȡ�ж��󣬲�ָ���м�
		Put row=new Put("row1".getBytes());
		//--�������Ҫ�����������е�����
		row.add("cf1".getBytes(),"name".getBytes(),"tom".getBytes());
		row.add("cf1".getBytes(),"age".getBytes(),"23".getBytes());
		row.add("cf2".getBytes(),"gender".getBytes(),"man".getBytes());
		
		//--ִ�в���
		table.put(row);
		table.close();
	}
	@Test
	public void put100Rows() throws Exception{
		Configuration conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum",
				"192.168.150.137:2181,"
				+ "192.168.150.138:2181,"
				+ "192.168.150.139:2181");
		
		HTable table=new HTable(conf,"tab2");
		
		//--HBase�ᰴrowkey���ֵ�������
		for(int i=1;i<=100;i++){
			Put row=new Put(("row"+i).getBytes());
			row.add("cf1".getBytes(),"number".getBytes(),(i+"").getBytes());
			table.put(row);
		}
		
		table.close();
		
	}
	
	@Test
	public void getData() throws Exception{
		Configuration conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum",
				"192.168.150.137:2181,"
				+ "192.168.150.138:2181,"
				+ "192.168.150.139:2181");
		
		HTable table=new HTable(conf, "tab1");
		
		//--ָ��Ҫ��ȡ���м�����
		//--HBase��������һ��key-value�洢ϵͳ��key���м�
		//--value���м���Ӧ���������弯��
		Get get=new Get("row1".getBytes());
		//--ִ�в�ѯ�������ؽ����
		Result result=table.get(get);
		
		byte[] name=result.getValue("cf1".getBytes(),
									"name".getBytes());
		
		byte[] age=result.getValue("cf1".getBytes(),
								   "age".getBytes());
		
		byte[] gender=result.getValue("cf2".getBytes(),
									  "gender".getBytes());
		
		System.out.println(new String(name)+new String(age)+new String(gender));
		
		table.close();
	}
	
	@Test
	public void scantable() throws Exception{
		Configuration conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum",
				"192.168.150.137:2181,"
				+ "192.168.150.138:2181,"
				+ "192.168.150.139:2181");
		
		HTable table=new HTable(conf,"tab2");
		
		//--��ȡ��ɨ����󣬿���ͨ���˶���ɨ������
		Scan scan=new Scan();
		//--ָ��ɨ�����ʼ�м�
		//scan.setStartRow("row1".getBytes());
		//--ָ��ɨ�����ֹ�м�λ�ã�������ֹλ��
		//scan.setStopRow("row30".getBytes());
		
		//--ָֻ����ʼλ�ã������ʼλ�õ������������ݶ��õ�
		scan.setStartRow("row30".getBytes());
		
		//--ִ������ɨ��,�����ؽ����
		ResultScanner result= table.getScanner(scan);
		Iterator<Result> it=result.iterator();
		
		while(it.hasNext()){
			Result r=it.next();
			byte[] number=r.getValue("cf1".getBytes(),
									 "number".getBytes());
			
			System.out.println(new String(number));
		}
		table.close();
	}
	
	@Test
	public void deleteRow() throws Exception{
		Configuration conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum",
				"192.168.150.137:2181,"
				+ "192.168.150.138:2181,"
				+ "192.168.150.139:2181");
		HTable table=new HTable(conf,"tab1");
		
		Delete delete=new Delete("row1".getBytes());
		//--ִ��ɾ��
		table.delete(delete);
		
		table.close();
		
	}
	
	@Test
	public void droptable() throws Exception{
		Configuration conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum",
				"192.168.150.137:2181,"
				+ "192.168.150.138:2181,"
				+ "192.168.150.139:2181");
		HBaseAdmin admin=new HBaseAdmin(conf);
		//--���ñ�
		admin.disableTable("tab1");
		//--ɾ����
		admin.deleteTable("tab1");
		
		admin.close();
	}
}
