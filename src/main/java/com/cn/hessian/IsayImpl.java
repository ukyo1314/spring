package com.cn.hessian;

import org.springframework.stereotype.Service;

@Service("isay")
public class IsayImpl implements Isay {

	public String sayHello(String arg1, String arg2) {
		return "Hello:" + arg1 + arg2;
	}
}