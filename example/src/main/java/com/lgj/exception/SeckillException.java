package com.lgj.exception;

import java.io.Serializable;

/**
 * 秒杀异常
 * @author 李高杰
 *
 */
public class SeckillException extends RuntimeException implements Serializable{
	private static final long serialVersionUID = 8544770926134653775L;

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillException(String message) {
		super(message);
	}

}
