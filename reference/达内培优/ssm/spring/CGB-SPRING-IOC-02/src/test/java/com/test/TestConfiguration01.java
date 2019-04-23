package com.test;
import java.util.Map;
import org.junit.Test;
import com.beans.Configuration;
public class TestConfiguration01 extends TestBase {
	@Test
	public void TestConfiguration(){
		Configuration cfg=
		ctx.getBean("config", Configuration.class);
		System.out.println(cfg.getList());
		Map<String,Object> map=cfg.getMap();
		System.out.println(map);
		System.out.println(map.getClass().getName());
		System.out.println(cfg.getProperties());
	}
}
