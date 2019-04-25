package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.泛型是什么？
 * 
 * 1)JDK1.5推出的一种JAVA特性
 * 2)Java中的一种编译时类型，运行时无效。
 * 3)是JAVA强类型语言的一种补充和完善(例如定义List时
 * 可以在编译时执行此容器中要放的数据类型)。
 * 4)类似生活中的标签.(例如盒子上贴了标签允许放什么)
 * 
 * 2.泛型推出的目的？
 * 
 * 1)对JAVA语言进行类型增强。
 * 2)提高程序可读性,运行时效率。
 * 3)可以更好的实现通用性编程，对代码进行抽取实现代码复用。
 * 
 * 3.泛型应用的类型？
 * 1)类泛型：类名<泛型>-->约束类中属性，方法参数以及返回值类型
 * 2)方法泛型：<泛型>方法返回值类型 方法名(参数列表)
 */

class Container<T>{//类泛型
	private T field;
	public void add(T a){
		System.out.println(a);
	}
	public T get(){
		return null;
	}
}
class Containers{
	 //泛型方法
	 public static <T>T getBean(Class<T> cls)throws Exception{
		 return (T)cls.newInstance();
	 }
	 public static <E>void doSort(List<? extends E> list){
	 }
}
public class TestGeneric01 {//List<T>

	public static void main(String[] args) throws Exception {
	   Container<Integer> c1=new Container<Integer>();
	   c1.add(100);
	   Container<String> c2=new Container<String>();
	   c2.add("helloworld");
	   
	   String a=Containers.getBean(String.class);
	}
}





