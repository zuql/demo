package cn.tarena;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.junit.Test;

public class TestFilter {
	
	/*
	 * �ص����� ������ƥ�������(ƥ���м��ģ�
	 * ����ֵ������(ƥ����ֵ)
	 */
	@Test
	public void regexFilter() throws Exception{
		Configuration conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum","hadoop01:2181,hadoop02:2181,hadoop03:2181");
		
		HTable table=new HTable(conf,"tab3");
		//--��ʹ�ù��������������ɨ������ɨ�跶Χ��ʹ��
		Scan scan=new Scan();
//		scan.setStartRow("row30".getBytes());
//		scan.setStopRow("row60".getBytes());
		
		//--����ƥ���������������ƥ���м��к�3���м���
//		Filter filter=new RowFilter(CompareOp.EQUAL,
//						 new RegexStringComparator("^.*3.*$"));
		
		//--�м��ȽϹ��������ȽϹ��򣺢ٵ��� �ڴ��� �� С�� �ܴ��ڵ��� ��С�ڵ���
//		Filter filter=new RowFilter(CompareOp.LESS_OR_EQUAL, 
//							new BinaryComparator("row90".getBytes()));
		
		//--�м�ǰ׺������
//		Filter filter=new PrefixFilter("row3".getBytes());
		
		//--��ֵ��������ƥ��ָ��������ֵ������������
		Filter filter=new SingleColumnValueFilter("cf1".getBytes(),"name".getBytes(),
												CompareOp.EQUAL,"rose".getBytes());
		
		scan.setFilter(filter);
		ResultScanner result=table.getScanner(scan);
		Iterator<Result> it=result.iterator();
		
		while(it.hasNext()){
			Result r=it.next();
			byte[] name=r.getValue("cf1".getBytes(),"name".getBytes());
			byte[] age=r.getValue("cf1".getBytes(),"age".getBytes());
			System.out.println(new String(name)+":"+new String(age));
		}
		table.close();
		
	}

}
