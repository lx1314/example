package com.lgj.entity;

import java.util.Date;

import javax.persistence.Table;


@Table(name = "Seckill")
public class Seckill {
	
    private long scekillId;
    private String name;
	private int inventory;
    private String startTime;
    private String endtime;
    private Date createTime; 
    
    public long getScekillId() {
		return scekillId;
	}
	public void setScekillId(long scekillId) {
		this.scekillId = scekillId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endtime;
	}
	public void setEndTime(String endtime) {
		this.endtime = endtime;
	}
	public Date getCreareTime() {
		return createTime;
	}
	public void setCreareTIme(Date creareTIme) {
		this.createTime = creareTIme;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public Date getCreateTIme() {
		return createTime;
	}
	public void setCreateTIme(Date createTIme) {
		this.createTime = createTIme;
	}
	@Override
	public String toString() {
		return "Seckill [scekillId=" + scekillId + ", name=" + name + ", inventory=" + inventory + ", startTime="
				+ startTime + ", endtime=" + endtime + ", createTIme=" + createTime + "]";
	}
	

}