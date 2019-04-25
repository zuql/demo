package generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestGeneric02 {
	//课后扩展作业
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	    List<String> list=
	    	new ArrayList<String>();//Object[]
	    list.add("A");
	    list.add("B");
	    //list.add(100);//要求把整数100放入集合(通过反射实现)
	    
	    //通过反射获取方法对象
	    Method method=
	    list.getClass().getDeclaredMethod(
	    		"add",Object.class);
	    //通过反射调用方法对象
	    //调用list对象的add方法，存储数据100
	    method.invoke(list, 100);
	    System.out.println(list);
	}
}




