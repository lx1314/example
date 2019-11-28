package com.lgj.enums;

public enum SeckillStateEnum implements Checker{
	
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    INNER_REWITE(-3,"数据篡改"),
    ;
	private int state;
	private String stateInfo;
	
	private SeckillStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	@Override
	public int getCode() {
		return state;
	}
	@Override
	public String getMessage() {
		return stateInfo;
	}
	
    public static boolean exist(int code){
    	SeckillStateEnum[] values = SeckillStateEnum.values();
        for (SeckillStateEnum type : values){
            if (type.getCode() == code){
                return true;
            }
        }
        return false;
    }
	

}
