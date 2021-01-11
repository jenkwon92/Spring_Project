package com.koreait.petshop.model.member.repository;

import java.util.List;

import com.koreait.petshop.model.domain.Member;

public interface MemberDAO {
	public List selectAll(); //��� ȸ����������
	public Member select(Member member);//ȸ�� 1�� ��������
	public void insert(Member member); //ȸ�����
	public void update(Member member); //ȸ������
	public void delete(Member member); //ȸ������
	
	public int duplicateCheck(String user_id); //�ߺ����� üũ
}