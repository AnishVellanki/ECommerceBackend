package com.ani.ECommerceBackend.daoImpl;

import java.util.List;

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
		if(category.getCategoryId()==0)
		{
			System.out.println("---"+category.getCategoryId());
		int id=(int)(Math.random()*10000);
		category.setCategoryId(id);
		}
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
		// TODO Auto-generated method stub
		return false;
	}

	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
