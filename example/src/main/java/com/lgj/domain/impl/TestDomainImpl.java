/**
 * Copyright (c) 2017 Baozun All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Baozun. You shall not disclose such 
 * Confidential Information and shall use it only in accordance with the terms of the license agreement 
 * you entered into with Baozun.
 *
 * BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY 
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */ 
package com.lgj.domain.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lgj.domain.TestDomain;
import com.lgj.entity.Country;
import com.lgj.redis.RedisClient;
import com.lgj.service.TestService;

/**   
 * <功能描述>
 * @author lsh8918  
 * @version 1.2.0  
 * @date 2019年6月5日 下午4:50:20
 * @since JDK 1.8  
 */
@Service
public class TestDomainImpl implements TestDomain{

    @Autowired
    private TestService testService;
    
    @Autowired
    private RedisClient redisClient;
    
    private static Logger log = LoggerFactory.getLogger(TestDomainImpl.class);
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Override
    public List<Country> query(){
        List<Country> find = testService.find();
        String jsonString = JSONObject.toJSONString(find);
        String testKey = "testKey";
/*        for (int i = 0; i < 6; i++) {
        	stringRedisTemplate.opsForValue().set(testKey+i, jsonString);
		}*/
        
        Object object = stringRedisTemplate.opsForHash().get("test", testKey);
        String jsonString2 = JSON.toJSONString(object);
        
        
        List<Country> parseArray = JSON.parseArray(jsonString2, Country.class);
        
//        redisClient.putHash(test, testKey1, jsonString);
//        stringRedisTemplate.opsForHash().scan(arg0, arg1);
        log.info(jsonString);
        return find;
    }
    
    @Override
    public void setHash(){
      List<Country> find = testService.find();
      String jsonString = JSONObject.toJSONString(find);
      String test = "test";
      redisClient.putHash(test, "testKey", jsonString);
      redisClient.putHash(test, "testKey1", jsonString);
      redisClient.putHash(test, "testKey2", jsonString);

    	
    }
    

}
  
