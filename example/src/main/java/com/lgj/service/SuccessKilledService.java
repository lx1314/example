package com.lgj.service;

import com.lgj.entity.Successkilled;

public interface SuccessKilledService {

	/**插入购买明细，克过滤重复
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertSuccessKilled(long seckillId,long  userPhone);
	
	  
	/**根据id查询明细对象并携带秒杀产品对象尸体
	 * @param seckillId
	 * @return
	 */
	Successkilled queryByIdWithSeckill(long seckillId);
	

}
