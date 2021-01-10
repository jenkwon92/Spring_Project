package com.koreait.petshop.exception;


//CRUD작업시 발생되는 예외 
//등록시 예외 exception
public class MailSendException extends RuntimeException{

	public MailSendException(String msg) {
		super(msg);
		
	}
	
	public MailSendException(String msg, Throwable e) {
		super(msg, e);
	}
}
