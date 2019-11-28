package com.lgj.service;

import java.util.List;

import com.lgj.dto.Exposer;
import com.lgj.dto.SeckillExecution;
import com.lgj.entity.Seckill;
import com.lgj.exception.RepeatKillException;
import com.lgj.exception.SeckillCloseException;
import com.lgj.exception.SeckillException;

/*
 * 业务接口：站在使用者的角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 */
public interface SeckillService {
	
	/**减库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(long seckillId,String killTime);
	
	/**根据id查询秒杀对象
	 * @param sckillId
	 * @return
	 */
	Seckill queryById(long sckillId);
	
	/**根据偏移量查询秒杀商品列表
	 * @param offet
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(int offet,int limit);
	
	/**查询所有秒杀记录
	 * @return
	 */
	List<Seckill> querySeckillList();

	/**
	 * 秒杀开启输出秒杀接口地址，
	 * 否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * 执行秒杀操作
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone,String md5) throws SeckillException,RepeatKillException, SeckillCloseException;

}
