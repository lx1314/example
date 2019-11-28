package com.lgj.exception;

public class RepeatKillException extends SeckillException{

	private static final long serialVersionUID = 7314599778462885962L;
	
    public RepeatKillException(String message){
    	super(message);
    	}

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}
    

}
