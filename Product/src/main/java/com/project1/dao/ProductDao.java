package com.project1.dao;


import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.query.Query;	
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project1.entity.Category;
import com.project1.entity.Product;
import com.project1.entity.ProductInfo;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory sf;
	
	public Product insert(Product product,int cid) {
		Session session=sf.openSession();
		
		 Category category=session.load(Category.class, cid);
		
         List<Product> productlist=category.getProducts();
		
         
		
		Transaction tr=session.beginTransaction();
		
		    productlist.add(product);
		
		tr.commit();
		session.close();
		
		return product;
		
	}
	
	public Product updateProduct(Product product) {
		Session session=sf.openSession();
		
		Transaction tr=session.beginTransaction();
		     
		         session.update(product);
		         
	     tr.commit();
	     
	   return product;  
	}
	
	
	public List<Product> allProduct() {
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Product.class);
		List<Product> list=cr.list();
		return list;
		
	}
	
	
	public List<ProductInfo> allProductsWithCategory(int pid) {
		Session session=sf.openSession();
		Query query=session.createSQLQuery("select product.pid,product.name,product.price,category.cid,category.name as cname from product join category on product.cid=category.cid and pid="+pid);
	    List<Object[]> list=query.list();
	    
	    ArrayList<ProductInfo> product=new ArrayList<ProductInfo>();
	    
	    for (Object[] array : list) {
			product.add(new ProductInfo((int)array[0], (String)array[1], (int)array[2], (int)array[3], (String)array[4]));
		}
	    
	    return product;
	
	}
	
	public Product deleteproduct(int pid) {
		Session session=sf.openSession();
		Product product=session.get(Product.class, pid);
		
		Transaction tx=session.beginTransaction();
		       session.delete(product);
		tx.commit();
		
		return product;
	}
	
	
	public Product viewproduct(int pid) {
		Session session=sf.openSession();
		Product product=session.get(Product.class, pid);
		return product;
	}
	
	
}
