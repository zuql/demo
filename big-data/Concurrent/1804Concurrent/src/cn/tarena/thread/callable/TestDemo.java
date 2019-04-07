package cn.tarena.thread.callable;
/**
 * Callable是jdk1.5之后提供新的线程机制，比Runnable的变化：
 * ①：call()的返回值类型可以自定义
 * ②：call()的返回值可以接到
 * ③：call()可以抛异常
 * ④：Callable线程类只能通过线程池启动。不能通过 new Thread().start()启动
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestDemo {

	public static void main(String[] args) throws Exception {
		ExecutorService service=Executors.newCachedThreadPool();
		Future<String> future=service.submit(new C1());
		//--获取对应线程call()的返回值
		String result=future.get();
		System.out.println(result);
		service.shutdown();
	}
}

class C1 implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("线程启动");
		return "success";
	}

}
