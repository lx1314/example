package com.lgj.dto;

import com.lgj.entity.Successkilled;
import com.lgj.enums.SeckillStateEnum;

/**
 * 封装秒杀执行后的结果
 * @author 李高杰
 *
 */
public class SeckillExecution {
	
	private long seckillId;
	private int state;///状态表示
	private String stateInfo;
	private Successkilled successkilled;
	
	
	public SeckillExecution(long seckillId,SeckillStateEnum stateEnum,  Successkilled successkilled) {
		super();
		this.seckillId = seckillId;
		this.state = stateEnum.getCode();
		this.stateInfo = stateEnum.getMessage();
		this.successkilled = successkilled;
	}

	public SeckillExecution(SeckillStateEnum stateEnum) {
		super();
		this.state = stateEnum.getCode();
		this.stateInfo = stateEnum.getMessage();
	}


	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public Successkilled getSuccesskilled() {
		return successkilled;
	}
	public void setSuccesskilled(Successkilled successkilled) {
		this.successkilled = successkilled;
	}

	
}
