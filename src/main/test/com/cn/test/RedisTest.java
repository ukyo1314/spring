package com.cn.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.redis.User;
import com.cn.redis.UserDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class RedisTest extends AbstractJUnit4SpringContextTests {  
      
    @Autowired  
    private UserDao<?, ?> userDao;  
      
    /** 
     * ���� 
     * <br>------------------------------<br> 
     */  
    @Test  
    public void testAddUser() {  
        User user = new User();  
        user.setId("user1");  
        user.setName("java2000_wl");  
        boolean result = userDao.add(user);  
        Assert.assertTrue(result);  
    }  
      
    /** 
     * �������� ��ͨ��ʽ 
     * <br>------------------------------<br> 
     */  
    @Test  
    public void testAddUsers1() {  
        List<User> list = new ArrayList<User>();  
        for (int i = 10; i < 50000; i++) {  
            User user = new User();  
            user.setId("user" + i);  
            user.setName("java2000_wl" + i);  
            list.add(user);  
        }
        long begin = System.currentTimeMillis();  
        for (User user : list) {
        	userDao.add(user);  
        }  
        System.out.println(System.currentTimeMillis() -  begin);  
    }  
      
    /** 
     * �������� pipeline��ʽ 
     * <br>------------------------------<br> 
     */  
    @Test  
    public void testAddUsers2() {  
        List<User> list = new ArrayList<User>();  
        for (int i = 10; i < 1500000; i++) {  
            User user = new User();  
            user.setId("user" + i);  
            user.setName("java2000_wl" + i);  
            list.add(user);  
        }  
        long begin = System.currentTimeMillis();  
        boolean result = userDao.add(list);  
        System.out.println(System.currentTimeMillis() - begin);  
        Assert.assertTrue(result);  
    }  
      
    /** 
     * �޸� 
     * <br>------------------------------<br> 
     */  
    @Test  
    public void testUpdate() {  
        User user = new User();  
        user.setId("user1");  
        user.setName("new_password");  
        boolean result = userDao.update(user);  
        Assert.assertTrue(result);  
    }  
      
    /** 
     * ͨ��keyɾ������ 
     * <br>------------------------------<br> 
     */  
    @Test  
    public void testDelete() {  
        String key = "user2";  
        userDao.delete(key);  
    }  
      
    /** 
     * ����ɾ�� 
     * <br>------------------------------<br> 
     */  
    @Test  
    public void testDeletes() {  
        List<String> list = new ArrayList<String>();  
        for (int i = 30; i < 10; i++) {  
            list.add("user" + i);  
        }  
        userDao.delete(list);  
    }  
      
    /** 
     * ��ȡ 
     * <br>------------------------------<br> 
     */  
    @Test  
    public void testGetUser() {  
        String id = "user1";  
        User user = userDao.get(id);  
        Assert.assertNotNull(user);  
        Assert.assertEquals(user.getName(), "java2000_wl");  
    }  
  
    /** 
     * ����userDao 
     * @param userDao the userDao to set 
     */  
    public void setUserDao(UserDao<?, ?> userDao) {  
        this.userDao = userDao;  
    }  
}  