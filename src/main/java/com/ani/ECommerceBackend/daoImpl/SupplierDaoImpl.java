package com.ani.ECommerceBackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.ECommerceBackend.dao.SupplierDao;
import com.ani.ECommerceBackend.model.Supplier;

@Component("supDaoImpl")
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory factory;
	public boolean saveSupplier(Supplier supplier) {
		
		Session session= factory.openSession();
		
		session.save(supplier);
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
		finally {
			session.close();
		}
		
	}

	public boolean deleteSupplier(Supplier supplier) {
		Session session=factory.openSession();
		//Category category=session.get(Category.class, categoryId);
		//System.out.println("~~~~~~"+category);
		//System.out.println("~~~~~~~"+category.getCategoryId());
		//System.out.println("~~~~~~~"+category.getCategoryDescription());
		
		session.delete(supplier);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return false;
	}

	public Supplier getSupplier(int supplierId) {
		Session session= factory.openSession();	
		Supplier supplier=session.get(Supplier.class, supplierId);
		session.close();
		return supplier;

	}

	public List<Supplier> getSupplierList() {
		
		Session session=factory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> supplierlist=query.list();
		for(Supplier sp:supplierlist)
		{
			System.out.println(sp.getSupplierDescription());
			System.out.println(sp.getSupplierName());
		}
		session.close();
	return  supplierlist;
	
	}

public boolean editSupplier(Supplier supplier) {
		
		Session session= factory.openSession();
		
		session.update(supplier);
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
		finally {
			session.close();
		}
		
	}
	
	
}
