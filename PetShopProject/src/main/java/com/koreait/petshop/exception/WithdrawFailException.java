package com.koreait.petshop.exception;


//출금할때 예외
public class WithdrawFailException extends RuntimeException{

	public WithdrawFailException(String msg) {
		super(msg);
		
	}
	
	public WithdrawFailException(String msg, Throwable e) {
		super(msg, e);
	}
}
