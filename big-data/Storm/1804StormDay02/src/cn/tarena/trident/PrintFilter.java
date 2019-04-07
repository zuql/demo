package cn.tarena.trident;

import java.util.Iterator;

import backtype.storm.tuple.Fields;
import storm.trident.operation.BaseFilter;
import storm.trident.tuple.TridentTuple;

/**
 * �������η�����tuple������ӡ��������
 * @author ysq
 *
 */
public class PrintFilter extends BaseFilter{

	@Override
	public boolean isKeep(TridentTuple tuple) {
	
		
		Fields keys=tuple.getFields();
		//--��ȡtuple������key�ֶεĵ�����
		Iterator<String> it= keys.iterator();
		while(it.hasNext()){
			//--��ȡһ��key�ֶ�
			String key=it.next();
			Object value=tuple.getValueByField(key);
			System.out.println(key+":"+value);
		}
		return false;
	}

}
