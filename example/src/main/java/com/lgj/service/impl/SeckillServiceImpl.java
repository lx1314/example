package com.lgj.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lgj.commom.MD5Util;
import com.lgj.dto.Exposer;
import com.lgj.dto.SeckillExecution;
import com.lgj.entity.Seckill;
import com.lgj.entity.Successkilled;
import com.lgj.enums.SeckillStateEnum;
import com.lgj.exception.RepeatKillException;
import com.lgj.exception.SeckillCloseException;
import com.lgj.exception.SeckillException;
import com.lgj.mapper.SeckillDao;
import com.lgj.mapper.SuccessKilledDao;
import com.lgj.service.SeckillService;
@Service
public class SeckillServiceImpl implements SeckillService{

	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Autowired
	private SuccessKilledDao successKilledDao;
	 
	
	/**
	 * MD5盐值字符串，用于混淆md5
	 */
	private final String slat="qdrqfsdffadfe5dft90e050kfkdifiosdfdgks,kfgoi8du";
	
	@Override
	public List<Seckill> queryAll(int offet, int limit) {
		List<Seckill> queryAll = seckillDao.queryAll(offet, limit);
		return queryAll;
	}
	
	@Override
	@Transactional
	public int reduceNumber(long seckillId, String killTime) {
		
		int reduceNumber = seckillDao.reduceNumber(seckillId, killTime);
		return reduceNumber;
	}
	
	@Override
	public Seckill queryById(long sckillId) {
		Seckill queryById = seckillDao.queryById(sckillId);
		return queryById;
	}


	@Override
	public List<Seckill> querySeckillList() {
		 List<Seckill> queryAll = seckillDao.queryAll(0, 4);
		return queryAll;
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}
		String startTime = seckill.getStartTime();
		String endTime = seckill.getEndTime();
		//系统当前时间
		Date date = new Date();
		long time = date.getTime();
		long end = Long.parseLong(endTime);
		long start = Long.parseLong(startTime);
		if (time < start || time > end) {
			return new Exposer(false, time, start, end, seckillId);
		}
		
		String md5 = getMD5(seckillId);
		// TODO Auto-generated method stub
		return new Exposer(true, md5, seckillId);
	}
	
	private String getMD5(long seckillId){
		String base = seckillId + "/" +slat;
		String md5 = MD5Util.MD5(base);
		return md5;
	}

	@Override
	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		if (Strings.isBlank(md5) || md5.equals(getMD5(seckillId))) {
			throw new SeckillException("seckill data rewrite");
		}
		Date date = new Date();
		long killTime = date.getTime();
		try {
			
			int updateCount = seckillDao.reduceNumber(seckillId, String.valueOf(killTime));
			if (updateCount <= 0) {
				throw new SeckillCloseException("seckill is close");
			}else {
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if (insertCount <= 0) {
					throw new RepeatKillException("repeat is suckill");
				}else {
					//TODO。。。 实体对象待完成
					Successkilled entity = new Successkilled();
					entity.setSeckillId(seckillId);
					entity.setUserPhone(userPhone);
					//秒杀成功
					Successkilled successkilled = successKilledDao.selectByPrimaryKey(entity);
					
					return new SeckillExecution(seckillId,SeckillStateEnum.SUCCESS, successkilled);
				}
			}
		}catch (SeckillCloseException e1) {
			throw e1;
		}catch (RepeatKillException e1) {
			throw e1;
		}catch (Exception e) {
			logger.error(e.getMessage());
			throw new SeckillException("seckill inner error:"+ e.getMessage());
		}
		
	}

}
