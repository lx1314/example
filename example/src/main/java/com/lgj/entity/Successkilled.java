package com.lgj.entity;

import java.util.Date;

import javax.persistence.Table;

@Table(name = "success_killed")
public class Successkilled {
	
    private long seckillId;
    private long userPhone;
    private short state;
    private Date createTime;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTIme(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Successkilled [scekillId=" + seckillId + ", userPhone=" + userPhone + ", state=" + state
				+ ", createTIme=" + createTime +  "]";
	} 
    

        

}