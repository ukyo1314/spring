package com.cn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class QuartzTest extends AbstractJUnit4SpringContextTests {
	@Test
	public void deal() throws InterruptedException{
		Thread.sleep(1000000);
	}
}