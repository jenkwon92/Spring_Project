package com.koreait.petshop2.exception;


//입금할때 예외
public class DepositFailException extends RuntimeException{

	public DepositFailException(String msg) {
		super(msg);
		
	}
	
	public DepositFailException(String msg, Throwable e) {
		super(msg, e);
	}
}
