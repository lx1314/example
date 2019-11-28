package com.lgj.dto;

import java.util.List;

import com.lgj.entity.Successkilled;

public class SuccessResult {

    private long scekillId;
    private String name;
	private int inventory;
    private String startTime;
    private String endtime;
    List<Successkilled> successkilleds;
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
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public List<Successkilled> getSuccesskilleds() {
		return successkilleds;
	}
	public void setSuccesskilleds(List<Successkilled> successkilleds) {
		this.successkilleds = successkilleds;
	}


}
