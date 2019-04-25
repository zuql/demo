package com.jt.common.utils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *@Component 描述类为一个一般的Bean对象
 */
@Lazy(true)//延迟加载仅针对于单例作用域对象(不写@Lazy就是实时加载)
@Scope("singleton")//默认是singleton(不配置也是单例)
//假如希望是多例，可以设置值为prototype
@Component //<bean id="openDataSouce" class="com.jt.common.utils.OpenDataSource">
public class OpenDataSource {//key默认为类名，首字母要小写
    /**
     * @PostConstruct 注解描述的方法为生命周期方法中的初始化方法
     * 要求：jdk1.7
     */
	@PostConstruct
	public void init(){
		System.out.println("init()");
	}
	/**
	 * @PreDestroy 描述的方法为生命周期销毁时要调用的方法
	 * 要求：jdk1.7
	 */
	@PreDestroy
	public void close(){
		System.out.println("destory()");
	}
}










