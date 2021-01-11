package com.koreait.petshop.exception;


//CRUD작업시 발생되는 예외 
//등록시 예외 exception
public class MemberRegistException extends RuntimeException{

	public MemberRegistException(String msg) {
		super(msg);
		
	}
	
	public MemberRegistException(String msg, Throwable e) {
		super(msg, e);
	}
}
