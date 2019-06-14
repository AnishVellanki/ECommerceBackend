package com.ani.ECommerceBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ani.ECommerceBackend.daoImpl.CategoryDaoImpl;
import com.ani.ECommerceBackend.daoImpl.SupplierDaoImpl;
import com.ani.ECommerceBackend.model.Category;
import com.ani.ECommerceBackend.model.Supplier;



public class SupplierTest {

	@Autowired
	Supplier supplier;
	
	static AnnotationConfigApplicationContext context;
	static SupplierDaoImpl supplierDaoImpl;

	@BeforeClass
	public static void Test1()
	{
		context=new AnnotationConfigApplicationContext();
			context.scan("com.ani.ECommerceBackend");
			context.refresh();
			supplierDaoImpl=(SupplierDaoImpl)context.getBean("supDaoImpl");
			
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~SaveSupplier~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Test
	public void saveSupplier_PositiveTesting()
	{
		
				Supplier supplier=new Supplier();
				supplier.setSupplierName("Jaya");
				supplier.setSupplierDescription("jay");
				supplier.setSupplierId(222);
	assertEquals("success",true,supplierDaoImpl.saveSupplier(supplier));
	}

	@Test
	public void saveSupplier_NegativeTesting()
	{
		
				Supplier supplier=new Supplier();
				supplier.setSupplierName("Raju");
				supplier.setSupplierDescription("raj");
				supplier.setSupplierId(103);
	assertEquals("success",false,supplierDaoImpl.saveSupplier(supplier));
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Test
	public void getSupplier_PositiveTesting()
	{
			
	assertEquals("success",true,supplierDaoImpl.getSupplierList());
	}
	
}

