package cn.tarena.map;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * 学习并发Map的创建和使用。
 * HashMap 线程并发非安全，但性能高
 * HashTable 线程并发安全，但性能低
 * @author ysq
 *
 */
public class TestDemo {

	/*
	 * ConcurrentHashMap，引入分段锁机制，底层分了16段(segment)
	 * 理论上并发性能要比Hash高16倍。
	 * 每个Segment可以看做是一个HashTable。即某个线程操作某个k,v时，
	 * 只会锁此k,v所在的Segment。而不锁其他的Segment。
	 * 此外，ConcurrentHashMap的存取方法和HashMap一致，
	 * 而且负载因子的概念和HashMap一致。
	 * 此外，底层的链表结构也和HashMap一致。
	 * 注意：以上所讲的是jdk1.8版本之前的ConcurrentHashMap
	 * jdk1.8之后，①用到CAS（compare and swap)无锁算法 ②底层把链表替换成红黑树
	 */
	@Test
	public void create(){
		ConcurrentHashMap<Integer, Integer> map=
				new ConcurrentHashMap<>();
		for(int i=0;i<1000;i++){
			map.put(i, i);
		}
		System.out.println();
	}
}
