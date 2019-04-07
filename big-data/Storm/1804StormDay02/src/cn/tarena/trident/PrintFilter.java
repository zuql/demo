package cn.tarena.trident;

import java.util.Iterator;

import backtype.storm.tuple.Fields;
import storm.trident.operation.BaseFilter;
import storm.trident.tuple.TridentTuple;

/**
 * 接收上游发来的tuple，并打印所有数据
 * @author ysq
 *
 */
public class PrintFilter extends BaseFilter{

	@Override
	public boolean isKeep(TridentTuple tuple) {
	
		
		Fields keys=tuple.getFields();
		//--获取tuple中所有key字段的迭代器
		Iterator<String> it= keys.iterator();
		while(it.hasNext()){
			//--获取一个key字段
			String key=it.next();
			Object value=tuple.getValueByField(key);
			System.out.println(key+":"+value);
		}
		return false;
	}

}
