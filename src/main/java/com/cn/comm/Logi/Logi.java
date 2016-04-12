package com.cn.comm.Logi;

import org.springframework.stereotype.Component;

@Component("logi")
public class Logi {
	public void before(){
		System.out.println("before");
	}
	
	public void after(){
		System.out.println("after");
	}
}
