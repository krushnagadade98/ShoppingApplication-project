package com.project1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.entity.Product;
import com.project1.entity.ProductInfo;
import com.project1.service.ProductService;

@RestController
@RequestMapping("productapi")
public class ProductController {
	
    @Autowired
	ProductService service;
    
    
    @PostMapping("insertproduct/{cid}")
    public Product insert(@RequestBody Product product,@PathVariable int cid) {
		return service.insert(product,cid);
	}
	
    @PutMapping("updateProduct")
     public Product updateProduct(@RequestBody  Product product) {
		
		return service.updateProduct(product);
	}
    
    @RequestMapping("allProduct")
    public List<Product> allProduct() {
		return service.allProduct();
	}
    
    @GetMapping("allProductsWithCategory/{pid}")
    public List<ProductInfo> allProductsWithCategory(@PathVariable int pid) {
		return service.allProductsWithCategory(pid);
	}
    
    @DeleteMapping("deleteproduct/{pid}")
    public Product deleteproduct(@PathVariable int pid) {
		return service.deleteproduct(pid);
	}
    
    @RequestMapping("viewproduct/{pid}")
    public Product viewproduct(@PathVariable int pid) {
		return service.viewproduct(pid);
	}
}
