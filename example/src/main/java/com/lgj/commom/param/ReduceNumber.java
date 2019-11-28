package com.lgj.commom.param;

public class ReduceNumber {
    private Integer seckillId;
    private String killTime;
	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(Integer scekillId) {
		this.seckillId = scekillId;
	}
	public String getKillTime() {
		return killTime;
	}
	public void setKillTime(String killTime) {
		this.killTime = killTime;
	}
	public ReduceNumber(Integer scekillId, String killTime) {
		super();
		this.seckillId = scekillId;
		this.killTime = killTime;
	}
	public ReduceNumber() {
		super();
	}
	@Override
	public String toString() {
		return "ReduceNumber [scekillId=" + seckillId + ", killTime=" + killTime + "]";
	} 
    

}
