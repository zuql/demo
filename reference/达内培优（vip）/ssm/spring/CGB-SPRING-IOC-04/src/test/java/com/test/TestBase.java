package com.test;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jt.common.config.AppRootConfig;
public class TestBase {
	protected AnnotationConfigApplicationContext ctx;
	@Before
	public void init(){
		//new ClassPathXmlApplicationContext(configLocations)
	    ctx = new AnnotationConfigApplicationContext(
	    		AppRootConfig.class);
	}
	@After
	public void close(){
		ctx.close();
	}
}
