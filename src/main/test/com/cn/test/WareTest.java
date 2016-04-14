package com.cn.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.myspring.po.AA;
import com.cn.myspring.service.WareService;
import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class WareTest extends AbstractJUnit4SpringContextTests {  
      
	@Autowired
	WareService wareService;
	
    /** 
     * ÐÂÔö 
     * <br>------------------------------<br> 
     */  
    @Test  
    public void testWareService() {  
    	List<AA> aalist = wareService.findAAList();
    	System.out.println(new Gson().toJson(aalist));;
    	
    }  
      
}  