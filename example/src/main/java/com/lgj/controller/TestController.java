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
package com.lgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lgj.domain.TestDomain;
import com.lgj.entity.Country;

/**   
 * <功能描述>
 * @author lsh8918  
 * @version 1.2.0  
 * @date 2019年6月5日 下午4:45:25
 * @since JDK 1.8  
 */
@RestController
public class TestController{
    
    @Autowired
    private TestDomain testDomain;
    @RequestMapping(value = "/query/test", method = RequestMethod.GET)
    public List<Country> query(){
        List<Country> query = testDomain.query();
        return query;
    }
    
    @RequestMapping(value = "/query/hash", method = RequestMethod.GET)
    public void getHash(){
         testDomain.setHash();
    }
    
    

}
  
