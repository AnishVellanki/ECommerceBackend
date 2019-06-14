package com.ani.ECommerceBackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ani.ECommerceBackend.dao.CategoryDao;
import com.ani.ECommerceBackend.model.Category;

@Component("catDaoImpl")
public class CategoryDaoImpl implements CategoryDao
{

	
	@Autowired
	SessionFactory factory;

	public boolean saveCategory(Category category) {

				
		//ApplicationContext context=new ClassPathXmlApplicationContext("dBConfig.xml");
		//SessionFactory sessionfactory=(SessionFactory) context.getBean("sessionFactory");
		System.out.println("~~~~~`"+factory);
		
		Session session=factory.openSession();
		
		session.save(category);
		Transaction transaction=session.beginTransaction();
		try {
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		finally
		{
			session.close();
		}
	}

	public boolean deleteCategory(Category category) {
		
		Session session=factory.openSession();
		//Category category=session.get(Category.class, categoryId);
		System.out.println("~~~~~~"+category);
		System.out.println("~~~~~~~"+category.getCategoryId());
		System.out.println("~~~~~~~"+category.getCategoryDescription());
		
		session.delete(category);
		try
		{
		Transaction transaction=session.beginTransaction();
		
		transaction.commit();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		finally
		{
			session.close();
		}
		}


	public Category getCategory(int categoryId) {
		Session session= factory.openSession();	
		Category category=session.get(Category.class, categoryId);
		session.close();
		return category;

	
	}

	public List<Category> getCategoryList() {
		Session session=factory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> categorylist=query.list();
		for(Category ca:categorylist)
		{
			System.out.println(ca.getCategoryId());
			System.out.println(ca.getCategoryDescription());
			System.out.println(ca.getCategoryName());
		}
		session.close();
	return  categorylist;
	
	}

	
	public boolean editCategory(Category category) {

		
		//ApplicationContext context=new ClassPathXmlApplicationContext("dBConfig.xml");
		//SessionFactory sessionfactory=(SessionFactory) context.getBean("sessionFactory");
		System.out.println("~~~~~`"+factory);
		
		Session session=factory.openSession();
		
		session.update(category);
		Transaction transaction=session.beginTransaction();
		try {
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		finally
		{
			session.close();
		}
	}
	
	

}
