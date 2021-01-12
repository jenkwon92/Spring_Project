package com.koreait.petshop.controller.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.petshop.exception.CartException;
import com.koreait.petshop.exception.LoginRequiredException;
import com.koreait.petshop.model.common.MessageData;
import com.koreait.petshop.model.domain.Cart;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.payment.service.PaymentService;



//장바구니, 주문 처리 컨트롤러, 비동기방식으로 처리하기 위한 컨트롤러
@Controller
@RequestMapping(value="/async")
public class RestPaymentController {

	private static final Logger logger = LoggerFactory.getLogger(RestPaymentController.class);
	
	@Autowired
	private  PaymentService paymentService; 
	
	//장바구니에 상품 담기
	//비동기로 담기
	@RequestMapping(value="/shop/cart/regist", method = RequestMethod.POST)
	@ResponseBody
	public MessageData registCart(Cart cart,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		  if(session.getAttribute("member")==null) { //여기서 예외를 처리하면 , 모든 컨트롤러 메서드마다 로그인과 관련된 코드가 중복되므로. 
			  //예외를 일으켜 하나의 메서드에서 처리하도록 재사용성을 높이자 
			  throw new LoginRequiredException("로그인이 필요한 서비스 입니다"); 
			  
		  }
		Member member =(Member)session.getAttribute("member");
		logger.debug("상품"+cart.getProduct_id());
		logger.debug("수량"+cart.getQuantity());
		cart.setMember_id(member.getMember_id());
		paymentService.insert(cart);
		
		//MessageConverter에 의해 VO는 JSON형태로 응답되어질 수 있다
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);//성공을 전제로 한 영역
		messageData.setMsg("장바구니에 상품이 담겼습니다.");
		messageData.setUrl("/shop/cart/list");
		return messageData;
	}


	//장바구니 예외처리
	@ExceptionHandler(CartException.class)
	@ResponseBody
	public MessageData hadelException(CartException e) {
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);//실패을 전제로 한 영역
		messageData.setMsg(e.getMessage());

		return messageData;
	}
	
	
	
}
