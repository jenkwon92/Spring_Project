package com.koreait.petshop2.model.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop2.model.domain.TopCategory;
import com.koreait.petshop2.model.product.repository.TopCategoryDAO;


@Service
public class TopCategoryServiceImpl implements TopCategoryService{

	@Autowired
	private TopCategoryDAO topCategoryDAO;
	
	public List selectAll() {
		return topCategoryDAO.selectAll();
	}

	public TopCategory select(int topcategory_id) {
		return null;
	}

	public void insert(TopCategory topcategory) {
		
	}

	public void update(TopCategory topcategory) {
		
	}

	public void delete(int topcategory_id) {
		
	}

}
