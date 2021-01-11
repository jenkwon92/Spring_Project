package com.koreait.petshop.model.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop.exception.CartException;
import com.koreait.petshop.model.domain.Cart;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.domain.OrderSummary;
import com.koreait.petshop.model.domain.Receiver;
import com.koreait.petshop.model.payment.repository.CartDAO;


@Service
public  class PaymentServiceImpl implements PaymentService{

	@Autowired
	private CartDAO cartDAO;
	


	
	//장바구니
	@Override
	public List selectCartList() {

		return null;
	}

	//장바구니리스트 가져오기 member_id가 등록된
	@Override
	public List selectCartList(int member_id) {
		
		return cartDAO.selectAll(member_id);
	}

	@Override
	public Cart selectCart(int cart_id) {
		
		return null;
	}

	@Override
	public void update(List<Cart> cartList) throws CartException{
		//상품 갯수만큼 수정 요청 
		for(Cart cart : cartList) {
			cartDAO.update(cart);
		}
	}

	@Override
	public void insert(Cart cart) throws CartException{
		
		cartDAO.duplicateCheck(cart);//장바구니 항목 체크
		
		cartDAO.insert(cart);
	}

	@Override
	public void delete(Cart cart) {
		
	}

	//장바구니에서 전체 삭제
	@Override
	public void delete(Member member) throws CartException {
		cartDAO.delete(member);
	}

	@Override
	public List selectPaymethodList() {
		return null;
	}

	@Override
	public void registOrder(OrderSummary orderSummary, Receiver receiver) {
		
		
	}

	
	
}
