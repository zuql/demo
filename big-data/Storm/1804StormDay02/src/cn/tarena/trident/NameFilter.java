package cn.tarena.trident;

import storm.trident.operation.BaseFilter;
import storm.trident.tuple.TridentTuple;

public class NameFilter extends BaseFilter{

	@Override
	public boolean isKeep(TridentTuple tuple) {
		String name=tuple.getStringByField("name");
		if(name.equals("tom")){
			//--false��ʾ:�������Ϊtom,��ѡ����ˣ������ʹ�tuple������
			return false;
		}else{
			return true;
		}
		
	}

}
