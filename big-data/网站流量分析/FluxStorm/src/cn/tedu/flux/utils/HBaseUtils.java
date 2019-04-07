package cn.tedu.flux.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;

import cn.tedu.flux.domain.FluxInfo;

public class HBaseUtils {
	private HBaseUtils() {
	}

	/**
	 * 向HBase中存入数据 由于没用泛型 只能存Flux表
	 * @Param tab 要存到哪个表
	 * @param fi 封装了信息的bean 对应的bean
	 */
	public static void putToHBase(String tabName,FluxInfo fi){
		HTable tab = null;
		try {
			//1.连接HBase表
			Configuration conf = HBaseConfiguration.create();
			conf.set("hbase.zookeeper.quorum","hadoop01:2181,hadoop02:2181,hadoop03:2181");
			tab = new HTable(conf,tabName);

			//2.向表中存入数据
			Put put = new Put(fi.getRk().getBytes());
			put.add("cf1".getBytes(), "url".getBytes(), fi.getUrl().getBytes());
			put.add("cf1".getBytes(), "urlname".getBytes(), fi.getUrlname().getBytes());
			put.add("cf1".getBytes(), "ref".getBytes(), fi.getRef().getBytes());
			put.add("cf1".getBytes(), "uagent".getBytes(), fi.getUagent().getBytes());
			put.add("cf1".getBytes(), "uvid".getBytes(), fi.getUvid().getBytes());
			put.add("cf1".getBytes(), "ssid".getBytes(), fi.getSsid().getBytes());
			put.add("cf1".getBytes(), "sscount".getBytes(), fi.getSscount().getBytes());
			put.add("cf1".getBytes(), "sstime".getBytes(), fi.getSstime().getBytes());
			put.add("cf1".getBytes(), "cip".getBytes(), fi.getCip().getBytes());
			tab.put(put);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			if(tab!=null){
				try {
					tab.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					tab = null;
				}
			}
		}
	}

	/**
	 * 查询HBase
	 * @param tabName 查询哪张表 此方法没有使用泛型 只能查Flux表
	 * @param start 开始行键
	 * @param stop 结束行键
	 * @param regex 根据正则过滤行键
	 * @return 查到的所有数据组成的Bean的集合
	 */
	public static List<FluxInfo> queryFromHBase(String tabName,byte[] start,byte[] stop,String regex){
		HTable tab = null;
		try {
			//1.连接HBase表
			Configuration conf = HBaseConfiguration.create();
			conf.set("hbase.zookeeper.quorum","hadoop01:2181,hadoop02:2181,hadoop03:2181");
			tab = new HTable(conf,tabName);

			//2.查询指定表
			Scan scan = new Scan();
			if(start != null){
				scan.setStartRow(start);
			}
			if(stop != null){
				scan.setStopRow(stop);
			}
			if(regex != null){
				Filter filter = new RowFilter(CompareOp.EQUAL, new RegexStringComparator(regex));
				scan.setFilter(filter);
			}

			ResultScanner rs = tab.getScanner(scan);
			Result r = null;
			List<FluxInfo> list = new ArrayList<>();
			while((r = rs.next())!=null){
				FluxInfo fi = new FluxInfo();
				fi.setUrl(new String(r.getValue("cf1".getBytes(), "url".getBytes())));
				fi.setUrlname(new String(r.getValue("cf1".getBytes(), "urlname".getBytes())));
				fi.setRef(new String(r.getValue("cf1".getBytes(), "ref".getBytes())));
				fi.setUagent(new String(r.getValue("cf1".getBytes(), "uagent".getBytes())));
				fi.setUvid(new String(r.getValue("cf1".getBytes(), "uvid".getBytes())));
				fi.setSsid(new String(r.getValue("cf1".getBytes(), "ssid".getBytes())));
				fi.setSscount(new String(r.getValue("cf1".getBytes(), "sscount".getBytes())));
				fi.setSstime(new String(r.getValue("cf1".getBytes(), "sstime".getBytes())));
				fi.setCip(new String(r.getValue("cf1".getBytes(), "cip".getBytes())));
				list.add(fi);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			if(tab!=null){
				try {
					tab.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					tab = null;
				}
			}
		}
	}
}
