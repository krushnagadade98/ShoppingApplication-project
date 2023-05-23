package com.project1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.dao.ProductDao;
import com.project1.entity.Product;
import com.project1.entity.ProductInfo;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;
	
	public Product insert(Product product,int cid) {
		return dao.insert(product,cid);
	}
	
	public Product updateProduct(Product product) {
		
		return dao.updateProduct(product);
	}


	public List<Product> allProduct() {
		return dao.allProduct();
	}
	
	public List<ProductInfo> allProductsWithCategory(int pid) {
		return dao.allProductsWithCategory(pid);
	}

	public Product deleteproduct(int pid) {
		return dao.deleteproduct(pid);
	}
	
	public Product viewproduct(int pid) {
		return dao.viewproduct(pid);
	}


}
