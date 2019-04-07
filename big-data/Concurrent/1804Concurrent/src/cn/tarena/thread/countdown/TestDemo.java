package cn.tarena.thread.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁也叫线程递减锁。可以通过闭锁让线程挂起或继续执行。
 * 主要是通过CountDown()和await()来实现。
 * @author ysq
 *
 */
public class TestDemo {

	public static void main(String[] args) throws Exception {

		CountDownLatch cdl=new CountDownLatch(2);

		new Thread(new BuyGuo(cdl)).start();
		new Thread(new BuyCai(cdl)).start();

		//--此方法会产生阻塞，阻塞放开的条件是闭锁初始数量=0
		cdl.await();
		System.out.println("开始做饭");
	}

}

class BuyGuo implements Runnable{
	private CountDownLatch cdl;

	public BuyGuo(CountDownLatch cdl) {
		this.cdl=cdl;
	}

	@Override
	public void run() {
		System.out.println("锅买回来了");
		//--此方法每调用一次，闭锁的初始数量-1

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cdl.countDown();

	}

}
class BuyCai implements Runnable{

	private CountDownLatch cdl;

	public BuyCai(CountDownLatch cdl) {
		this.cdl=cdl;
	}

	@Override
	public void run() {
		System.out.println("菜买回来了");
		cdl.countDown();

	}

}
