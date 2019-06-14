package com.ani.ECommerceBackend;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ani.ECommerceBackend.daoImpl.CategoryDaoImpl;
import com.ani.ECommerceBackend.model.Category;

public class TestBeans {

	@Autowired
	Category category;
	
	static AnnotationConfigApplicationContext context;
	static CategoryDaoImpl categoryDaoImpl;
	
	@BeforeClass
public static void Test1()
{
	context=new AnnotationConfigApplicationContext();
		context.scan("com.ani.ECommerceBackend");
		context.refresh();
		categoryDaoImpl=(CategoryDaoImpl)context.getBean("catDaoImpl");
		
}
	@Test
	public void saveCategory_PositiveTesting()
	{
		
				Category category=new Category();
		category.setCategoryName("Raju");
		category.setCategoryDescription("raj");
		category.setCategoryId(103);
	assertEquals("success",true,categoryDaoImpl.saveCategory(category));
	}

	@Test
	public void saveCategory_NegativeTesting()
	{
		
				Category category=new Category();
		category.setCategoryName("Raju");
		category.setCategoryDescription("raj");
		category.setCategoryId(103);
	assertEquals("success",false,categoryDaoImpl.saveCategory(category));
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~getCategoryList~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Test
	public void getCategoryList_PositiveTesting()
	{
		Category category=new Category();
		assertEquals("success",true,categoryDaoImpl.getCategoryList());
		
	}	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Test
	public void deleteCategory_PositiveTesting()
	{
		
	
		assertEquals("success",true,categoryDaoImpl.deleteCategory(category));
		
	}	

}
