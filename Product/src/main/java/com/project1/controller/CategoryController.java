package com.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.entity.Category;
import com.project1.entity.ObjectNotFoundException;
import com.project1.service.CategoryService;

@RestController
@RequestMapping("categoryapi")
public class CategoryController {

	@Autowired
	CategoryService service;
	
	@PostMapping("insert")
	public Category insert(@RequestBody  Category category) {
		
		System.out.println(category);
		return service.insert(category);
	}
	
	@RequestMapping("getCategory/{cid}")
	public Category getCategory(@PathVariable int cid)  {
		Category category= service.getCategory(cid);
		
		if(category==null) {
			throw new ObjectNotFoundException("No record Found with cid "+cid);
		}else {
			
			return category;
			
		}
		
	}
	
	@PutMapping("updateCategory")
	public Category updateCategory(@RequestBody Category category)  {
		return service.updateCategory(category);
	}
	
	
	@RequestMapping("deleteCategory/{cid}")
	public Category deleteCategory(@PathVariable int cid)  {
		return service.deleteCategory(cid);
	}
	
	@RequestMapping("getAll")
	public List<Category> getAll() {
		return service.getAll();
	}
}
