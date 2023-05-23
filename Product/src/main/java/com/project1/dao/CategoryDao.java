package com.project1.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project1.entity.Category;

@Repository
public class CategoryDao {

	@Autowired
	SessionFactory sf;

	public Category insert(Category category) {
		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		session.save(category);

		tr.commit();
		session.close();

		return category;
	}

	public Category getCategory(int cid) {
		Session session = sf.openSession();

		Category category=session.get(Category.class, cid);
		
//		Criteria criteria = session.createCriteria(Category.class);
//		criteria.add(Restrictions.eq("cid", cid));
//		List<Category> list = criteria.list();
//		Category category = list.get(0);
		return category;
	}

	public Category updateCategory(Category category) {
		
		Session session = sf.openSession();

		Transaction tr=session.beginTransaction();
		
	         session.update(category);
	    tr.commit();     
		
		return category;
	}

	public Category deleteCategory(int cid) {
		
		Session session = sf.openSession();

		Category category=session.get(Category.class, cid);
		
		Transaction tr = session.beginTransaction();

		         session.delete(category);

		tr.commit();
		session.close();

		return category;
		
	}
	
	public List<Category> getAll() {
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Category.class);
		List<Category> category=cr.list();
		return category;
	}
	
	
	
	
}
