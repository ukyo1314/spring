package com.cn.mongodb;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.data.mongodb.core.MongoTemplate;  
import org.springframework.data.mongodb.core.query.Criteria;  
import org.springframework.data.mongodb.core.query.Query;  
import org.springframework.stereotype.Service;  
   
@Service   
public class UserMgService {  
       
    private static String USER_COLLECTION = "user";  
   
    @Autowired  
    MongoTemplate mongoTemplate;  
       
    /** 
     *  
     * @param user 
     */  
    public void saveUser(UserMg user){
        mongoTemplate.save(user, USER_COLLECTION);  
    }  
       
    /** 
     *  
     * @param name 
     * @return  
     */  
    public UserMg findUserByName(String name){  
        return mongoTemplate.findOne(new Query(Criteria.where("name").is(name)), UserMg.class, USER_COLLECTION);  
    }  
       
}