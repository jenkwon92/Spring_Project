package com.koreait.petshop2.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	//������ ������ �̵�
	@RequestMapping("/admin")
	public String adminMain () {
		return "admin/main";
	}
	
}