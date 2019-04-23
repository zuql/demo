package cgb.interf;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

interface IService{
	public void sayHello();
}
class HelloService implements IService{
	@Override
	public void sayHello() {
		System.out.println("sayHello");
	}
	public void sayBye(){
		System.out.println("say bye");
	}
}

public class TestInterface01 {
	public static void doMethod02(){
		IService s=new HelloService();
		s.sayHello();
		((HelloService)s).sayBye();
	}
	
	public static void main(String[] args) {
		//doMethod01();
		doMethod02();
	}
    //alt+shift+m
	private static void doMethod01() {
		List<String> list=new ArrayList<>();
		list.add("A");
		list=new LinkedList<>();
		list.add("B");
		System.out.println(list);
	}
}
