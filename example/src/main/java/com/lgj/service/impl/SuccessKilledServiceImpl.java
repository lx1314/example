package com.lgj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgj.entity.Seckill;
import com.lgj.entity.Successkilled;
import com.lgj.mapper.SeckillDao;
import com.lgj.mapper.SuccessKilledDao;
import com.lgj.service.SuccessKilledService;

@Service
public class SuccessKilledServiceImpl implements SuccessKilledService{
	
	@Autowired
	private SeckillDao sd;
	
	@Autowired
	private SuccessKilledDao skd;

	@Override
	public int insertSuccessKilled(long seckillId, long userPhone) {
//		Successkilled sk = new  Successkilled();
//		sk.setSeckillId(seckillId);
//		sk.setUserPhone(userPhone);
//		int insert = skd.insert(sk);
		
		return skd.insertSuccessKilled(seckillId, userPhone);
	}

	@Override
	public Successkilled queryByIdWithSeckill(long seckillId) {
		Successkilled successkilled = new Successkilled();
		successkilled.setSeckillId(seckillId);
		Successkilled entity = skd.selectOne(successkilled);
		Seckill seckill = sd.queryById(seckillId);
//		entity.setSeckill(seckill);
		return entity;
	}

}
