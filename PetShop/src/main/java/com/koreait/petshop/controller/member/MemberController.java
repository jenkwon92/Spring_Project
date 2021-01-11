package com.koreait.petshop.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.exception.MailSendException;
import com.koreait.petshop.exception.MemberNotFoundException;
import com.koreait.petshop.exception.MemberRegistException;
import com.koreait.petshop.model.common.MessageData;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.member.service.MemberService;

@Controller
public class MemberController {
   private static final Logger logger=LoggerFactory.getLogger(MemberController.class);
   @Autowired
   private MemberService memberService;
   
   //ȸ������ �� 
   @RequestMapping(value="/shop/member/registForm", method=RequestMethod.GET)
   public String getRegistForm() {
      return "/shop/member/signup";
   }
   
   //ȸ�� ���� ��
   @RequestMapping(value="/shop/member/thanksForm")
   public String getThanksForm() {
      return "/shop/member/thanks";
   }
   
   //�α��� �� (�׺����ð�� ModelAndView�� �����ؾ���)
   @GetMapping("/shop/member/loginForm")
   public ModelAndView getLoginForm() {
      //topList ��û
      ModelAndView mav = new ModelAndView("/shop/member/signin");
      return mav;
   }
   
   //�α��� ��û ó��
   @PostMapping(value="/shop/member/login")
   public String login(Member member,HttpServletRequest request) {
      
      //db���翩��Ȯ��
      Member obj = memberService.select(member);
      //���ǿ� ȸ������ ��Ƶα�
      HttpSession session=request.getSession();
      session.setAttribute("member", obj); //���� Ŭ���̾�Ʈ ��û�� ����� ���ǿ� ����
      return "redirect:/";
   }
   
   //�α׾ƿ� ��û ó��
   @GetMapping(value="/shop/member/logout")
   public ModelAndView logout(HttpServletRequest request) {
      request.getSession().invalidate(); //���� ��ȿȭ. ���� ȿ�»��
      MessageData messageData = new MessageData();
      messageData.setResultCode(1);
      messageData.setMsg("�α׾ƿ� �Ǿ����ϴ�");
      messageData.setUrl("/");
      
      ModelAndView mav = new ModelAndView("/shop/message/shop_message");
      mav.addObject("messageData", messageData);
      
      return mav;
   }
   
   //���̵� �ߺ� �˻�
   @RequestMapping(value ="/shop/member/memberIdChk", method = RequestMethod.POST)
   @ResponseBody
   public String memberIdChkPost(String user_id) throws Exception{
         //logger.debug("memberIdChk() ����");
      int result= memberService.duplicateCheck(user_id);
      //logger.debug("��� ��:"+result);
      if(result ==0 ) {
         return "success"; //�ߺ����̵� ����
      }else {
         return "fail"; //�ߺ����̵� ����
      }
   }
   
   //ȸ������ ��ûó��
   @RequestMapping(value="/shop/member/regist", method=RequestMethod.POST, produces="text/html;charset=utf-8")
   @ResponseBody
   public String regist(Member member) {
      logger.debug("���̵�"+member.getUser_id());
      logger.debug("�̸�"+member.getName());
      logger.debug("��й�ȣ"+member.getPassword());
      logger.debug("�̸���"+member.getEmail_id());
      logger.debug("�̸��ϼ���"+member.getEmail_server());
      logger.debug("�����ȣ"+member.getZipcode());
      logger.debug("�ּ�"+member.getAddr());
      
      memberService.regist(member);
      
      StringBuffer sb = new StringBuffer();
      sb.append("{");
      sb.append(" \"result\":1, ");
      sb.append(" \"msg\":\"ȸ������ ����\"");
      sb.append("}");
      return sb.toString();
   }
   
   //���������� cart(�⺻��) ��ûó��
   @GetMapping("/shop/member/mypage_cart")
   public String mypageCart() {
      return "/shop/member/mypage_cart";
   }
   
   //���������� �������� ��ûó��
   @GetMapping("/shop/member/mypage_management")
   public String mypageModify() {
      return "/shop/member/mypage_management";
   }
   
   // Admin������   
   //ȸ�� ��� ����Ʈ
   @GetMapping("/admin/member/list")
   public ModelAndView getMemberList() {
      ModelAndView mav = new ModelAndView("admin/member/member_list");
   
      List memberList = memberService.selectAll();
      mav.addObject("memberList",memberList);
      
      logger.debug("memberList.size()"+memberList.size());
      
      return mav;
   }
   
   
   
   //���� �ڵ鷯 ó�� (���Կ���)
   @ExceptionHandler(MemberRegistException.class)
   @ResponseBody
   public String handleException(MemberRegistException e) {
      StringBuffer sb = new StringBuffer();
      sb.append("{");
      sb.append(" \"result\":0, ");
      sb.append(" \"msg\":\""+e.getMessage()+"\"");
      //���� ���� ���� �߻����� ���� ȸ�������� ������� �ʰ��ֽ��ϴ�. �ִ��� ���� ���� �����ϵ��� �ϰڽ��ϴ�. �̿뿡 ������ ����� �˼��մϴ�.
      sb.append("}");
      
      return sb.toString();
   }
   
   //���� �ڵ鷯 ó�� (���� �߼� ����)
   @ExceptionHandler(MailSendException.class)
   public ModelAndView handleException(MailSendException e) {
      ModelAndView mav = new ModelAndView();
      //���������� �̵�
      mav.addObject("msg", e.getMessage()); //����ڰ� ���Ե� �����޽���
      mav.setViewName("shop/error/result");
      
      //�ý��� �����ڿ��� �����˸���
      return mav;
   }
   
   //���� �ڵ鷯 ó�� (�α��� ����)
   @ExceptionHandler(MemberNotFoundException.class)
   public ModelAndView handleExceptio(MemberNotFoundException e) {
      ModelAndView mav = new ModelAndView();
      mav.addObject("msg", e.getMessage());
      mav.setViewName("shop/error/result");
   
      return mav;
   }
}