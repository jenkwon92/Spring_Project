package com.koreait.petshop.model.member.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop.exception.MailSendException;
import com.koreait.petshop.exception.MemberDeleteException;
import com.koreait.petshop.exception.MemberEditException;
import com.koreait.petshop.exception.MemberNotFoundException;
import com.koreait.petshop.exception.MemberRegistException;
import com.koreait.petshop.model.common.MailSender;
import com.koreait.petshop.model.common.SecureManager;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	
	//�̸��� �߼� ��ü
	@Autowired
	private MailSender mailSender;
	
	//��ȣȭ ��ü 
	@Autowired
	private SecureManager secureManager;
	
//Shop ���� ����	
	//ȸ����� �� ��Ÿ�ʿ���� ó��
	public void regist(Member member) throws MemberRegistException, MailSendException{
		//��й�ȣ ��ȣȭ ó�� 
		String secureData = secureManager.getSecureData(member.getPassword());
		member.setPassword(secureData); //��ȯ���� �ٽ� VO �� ����
		
		memberDAO.insert(member);
		
		String email =member.getEmail_id()+"@"+member.getEmail_server();
		String name=member.getName();
		String user_id= member.getUser_id();
		
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd��");
	
		mailSender.send(email, name+"��, [pet shop] �������ϵ����", 
				format.format(today)+"<br> ID : "+user_id+"�� �����ϼ̽��ϴ�. <br> �����մϴ�");
	}
	
	//���̵� �ߺ��˻�
	public int duplicateCheck(String user_id) {
		int result = memberDAO.duplicateCheck(user_id);
		if(result == 0) {
			return 0;
		}else {
			return 1;
		}
	}
		
	//ȸ�� �α���
	public Member select(Member member) throws MemberNotFoundException{
		//��� �ؽð����� ��ȯ�Ͽ� �޼���ȣ��
		String hash =secureManager.getSecureData(member.getPassword());
		member.setPassword(hash); //VO�� �ؽð� ����
		Member obj = memberDAO.select(member);
		return obj;
	}

	//ȸ�� ��������
	public void update(Member member) throws MemberEditException{
		String hash =secureManager.getSecureData(member.getPassword());
		member.setPassword(hash); //VO�� �ؽð� ����
		memberDAO.update(member);
	}
	

	//ȸ��Ż��
	public void delete(Member member) throws MemberDeleteException{
		String hash =secureManager.getSecureData(member.getPassword());
		member.setPassword(hash); //VO�� �ؽð� ����
		memberDAO.delete(member);
	}
	
//Admin���� ����
	//ȸ�� ��� 
	public List selectAll() {
		return memberDAO.selectAll();
	}
}