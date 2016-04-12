package com.cn.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hessian.Isay;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class HessionTest extends AbstractJUnit4SpringContextTests {

	@Resource
	Isay isayClient;

	@Test
	public void deal() throws InterruptedException {
		System.out.println(isayClient.sayHello("liu", "le"));
	}
}