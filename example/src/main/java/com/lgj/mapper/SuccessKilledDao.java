package com.lgj.mapper;

import org.apache.ibatis.annotations.Insert;

import com.lgj.entity.Successkilled;
import com.lgj.mymapper.MyMapper;

public interface SuccessKilledDao extends MyMapper<Successkilled>{
	

	/**插入购买明细，克过滤重复
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	@Insert("<script>"
	+ "insert into Success_Killed (seckill_id,user_Phone)"
	+ "values (#{seckillId},#{userPhone}) "
    + "</script>")
	int insertSuccessKilled(long seckillId,long  userPhone);
	
	  
	/**根据id查询明细对象并携带秒杀产品对象实体
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	Successkilled queryByIdWithSeckill(long seckillId, long  userPhone);
	

}
