package com.koreait.petshop.controller.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.product.service.ProductService;
import com.koreait.petshop.model.product.service.SubCategoryService;
import com.koreait.petshop.model.product.service.TopCategoryService;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private ProductService productService;
	
	//��� ��
	//��ϵ� ��ǰ��� ����Ʈ
	//@GetMapping("/admin/product/list")
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET )
	public ModelAndView getProductList() {
		ModelAndView mav = new ModelAndView("admin/product/product_list");
		
		List productList = productService.selectAll();	
		mav.addObject("productList", productList);
	
		logger.debug("productList.size()"+productList.size());

	
		return mav;
	}
	
	//��ǰ �󼼺���
	@RequestMapping(value="/admin/product/detail", method=RequestMethod.GET )
	public ModelAndView getProductDetail(int product_id) {
	List topList = topCategoryService.selectAll();//��ǰī�װ��� ���
		
		Product product = productService.select(product_id);//��ǰ �Ѱ� ��������
		
		ModelAndView mav = new ModelAndView("admin/product/detail");
	
		mav.addObject("product",product);
		
		return mav;
	}
	
	//��� ��
	//���� ī�װ��� ��������
	  @RequestMapping(value="/admin/product/registform" , method =	RequestMethod.GET) 
	  public ModelAndView getTopList() {
	  
	  List topList = topCategoryService.selectAll();
	  
	  ModelAndView mav = new ModelAndView(); mav.addObject("topList", topList);
	  mav.setViewName("admin/product/regist_form");
	  
	  return mav; 
	  }
	 
	 
}