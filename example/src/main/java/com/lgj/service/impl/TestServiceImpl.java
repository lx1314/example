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
package com.lgj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgj.entity.Country;
import com.lgj.mapper.TestAMapper;
import com.lgj.service.TestService;

/**   
 * <功能描述>
 * @author lsh8918  
 * @version 1.2.0  
 * @date 2019年6月5日 下午4:46:19
 * @since JDK 1.8  
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestAMapper testAMapper;
    @Override
    public List<Country> find(){
          
       List<Country> selectAll = testAMapper.selectAll();
        
        return selectAll;
    }

}
  
