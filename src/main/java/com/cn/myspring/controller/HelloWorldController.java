package com.cn.myspring.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cn.myspring.po.User;
import com.cn.myspring.service.UserService;

@Controller
@SessionAttributes("name")
public class HelloWorldController {

	@Autowired
	UserService userService;

	@RequestMapping("/hello")
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp,User user) throws Exception {
		// 1、收集参数、验证参数
		// 2、绑定参数到命令对象
		// 3、将命令对象传入业务对象进行业务处理
		// 4、选择下一个页面
		userService.insertUser(user);
		ModelAndView mv = new ModelAndView();
		// 添加模型数据 可以是任意的POJO对象
		mv.addObject("message", "Hello World!");
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("hello");
		mv.addObject("name", user.getName());
		Cookie name = new Cookie("name", URLEncoder.encode(user.getName(),
				"utf-8"));
		Cookie age = new Cookie("age", String.valueOf(user.getAge()));
		Cookie email = new Cookie("email", user.getEmail());
		resp.addCookie(name);
		resp.addCookie(age);
		resp.addCookie(email);
		return mv;
	}

	@RequestMapping("/ma")
	public ModelAndView to(HttpServletRequest req, HttpServletResponse resp,
			@ModelAttribute("message") String message) throws Exception {
		// 1、收集参数、验证参数
		// 2、绑定参数到命令对象
		// 3、将命令对象传入业务对象进行业务处理
		// 4、选择下一个页面
		System.out.println(message);
		ModelAndView mv = new ModelAndView();
		// 添加模型数据 可以是任意的POJO对象
		mv.addObject("message", "Hello World!");
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("hello");
		return mv;
	}

	@RequestMapping("/cookie")
	public ModelAndView to(HttpServletRequest req, HttpServletResponse resp,
			@CookieValue("name") String name, @CookieValue("age") String age,
			@CookieValue("email") String email) throws Exception {
		// 1、收集参数、验证参数
		// 2、绑定参数到命令对象
		// 3、将命令对象传入业务对象进行业务处理
		// 4、选择下一个页面
		System.out.println("%%" + URLDecoder.decode(name, "utf-8") + age
				+ email);
		ModelAndView mv = new ModelAndView();
		// 添加模型数据 可以是任意的POJO对象
		mv.addObject("message", "Hello World!");
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("hello");
		return mv;
	}

	@RequestMapping("/id/{id}")
	public ModelAndView id(HttpServletRequest req, HttpServletResponse resp,
			@PathVariable("id") int id) throws Exception {
		// 1、收集参数、验证参数
		// 2、绑定参数到命令对象
		// 3、将命令对象传入业务对象进行业务处理
		// 4、选择下一个页面
		System.out.println("id:" + id);
		ModelAndView mv = new ModelAndView();
		// 添加模型数据 可以是任意的POJO对象
		mv.addObject("message", "Hello World!");
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("hello");
		return mv;
	}
}