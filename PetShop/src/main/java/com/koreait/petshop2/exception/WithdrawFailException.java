package com.koreait.petshop2.exception;


//����Ҷ� ����
public class WithdrawFailException extends RuntimeException{

	public WithdrawFailException(String msg) {
		super(msg);
		
	}
	
	public WithdrawFailException(String msg, Throwable e) {
		super(msg, e);
	}
}