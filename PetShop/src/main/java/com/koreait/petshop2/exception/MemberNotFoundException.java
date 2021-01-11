package com.koreait.petshop2.exception;


//CRUD작업시 발생되는 예외 
//등록시 예외 exception
public class MemberNotFoundException extends RuntimeException{

	public MemberNotFoundException(String msg) {
		super(msg);
		
	}
	
	public MemberNotFoundException(String msg, Throwable e) {
		super(msg, e);
	}
}
