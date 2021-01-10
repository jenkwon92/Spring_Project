package com.koreait.petshop.model.product.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop.model.common.FileManager;
import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.product.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;

	//관리자모드 목록 가져오기
	@Override
	public List selectAll() {
	
		return productDAO.selectAll();
	}

	@Override
	public List selectById(int subcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	//관리자 모드 상품 상세보기
	@Override
	public Product select(int product_id) {
		
		return productDAO.select(product_id);
	}

	@Override
	public void regist(FileManager fileManager, Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		
	}

}
