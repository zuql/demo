package beans;
/**
 * 1.这个类的对象如何交给spring管理？
 * 
 * 1)Spring如何知道我们写了这样的一个类？(xml)
 * 2)Spring如何构建此类的对象？
 * 3)Spring如何存储此对象？
 * 
 * 2.我们使用此类对象时如何获取对象？
 */
public class HelloService {
	 public HelloService() {
		 System.out.println("HelloService()");
	 }
	 public void sayHello(){
		 System.out.println("helloworld");
	 }
}
