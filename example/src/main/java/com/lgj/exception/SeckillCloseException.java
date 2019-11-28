package com.lgj.exception;

/**
 * 秒杀关闭异常
 * @author 李高杰
 *
 */
public class SeckillCloseException extends SeckillException{

	private static final long serialVersionUID = -5274931652217065633L;

	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillCloseException(String message) {
		super(message);
	}


}
