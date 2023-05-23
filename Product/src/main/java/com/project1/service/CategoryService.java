package com.project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.dao.CategoryDao;
import com.project1.entity.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao dao;
	
	public Category insert(Category category) {
		return dao.insert(category);
	}

	public Category getCategory(int cid) {
		return dao.getCategory(cid);
		
	}

	public Category updateCategory(Category category) {
		return dao.updateCategory(category);
	}

	public Category deleteCategory(int cid) {
		return dao.deleteCategory(cid);
	}

	public List<Category> getAll() {
		return dao.getAll();
	}

}
