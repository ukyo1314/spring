package com.cn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.mongodb.UserMg;
import com.cn.mongodb.UserMgService;
import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class MongodbTest extends AbstractJUnit4SpringContextTests {  
      
	@Autowired
	UserMgService userMgService;
	
    /** 
     * ÐÂÔö 
     * <br>------------------------------<br> 
     */  
//    @Test  
//    public void testSaveUser() {  
//    	UserMg userMg = new UserMg();
//    	userMg.setName("liule");
//    	userMg.setAge(18);
//    	userMgService.saveUser(userMg);
//    }  
    
    /** 
     * ²éÕÒ 
     * <br>------------------------------<br> 
     */  
    @Test  
    public void testFindUserByName() {  
    	System.out.println(new Gson().toJson(userMgService.findUserByName("liule")));;
    }  
      
}  