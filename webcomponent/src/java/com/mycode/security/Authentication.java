/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycode.security;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.SecureRandom;

/**
 *
 * @author spatha11
 */
public class Authentication {
    
    public String getUserAuthenticationToken(String userName, String password){
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient("localhost", 27017);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        DB db = mongoClient.getDB("test");

        
        BasicDBObject doc = new BasicDBObject().append("userName", userName).append("password", password);
        SecureRandom random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
                 
        DBCollection userCredentials = db.createCollection("Authentication", doc);
        
        
        
        
        return token;
        
    }
    
}
