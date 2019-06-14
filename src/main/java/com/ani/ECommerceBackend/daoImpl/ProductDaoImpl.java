package com.ani.ECommerceBackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.ECommerceBackend.dao.ProductDao;
import com.ani.ECommerceBackend.model.Product;

@Component("proDaoImpl")
public class ProductDaoImpl implements ProductDao {
@Autowired
SessionFactory factory;
	
	public boolean saveProduct(Product product) {
		Session session= factory.openSession();
		
		session.save(product);
		try
		{
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		return true;
		}
		catch (Exception e)
		{
		return false;
		}
		finally {
			session.close();

		}		
	}

	public boolean deleteProduct(Product product) {
		Session session=factory.openSession();
		session.delete(product);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return true;
	}

	public Product getProduct(int productId) {
		Session session= factory.openSession();	
		Product product=session.get(Product.class, productId);
		session.close();
		return product;
		}

	public List<Product> getProductList() {
		Session session=factory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> productsList=query.list();
		for(Product p:productsList)
		{
			System.out.println(p.getProductId());
			System.out.println(p.getProductName());
			System.out.println(p.getProductDescription());
			System.out.println(p.getProductPrice());
			System.out.println(p.getProductCategory());
			System.out.println(p.getProductSupplier());
		
		}
		return productsList;
	
	}

	public boolean editProduct(Product product) {
		Session session= factory.openSession();
		
		session.update(product);
		try
		{
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		return true;
		}
		catch (Exception e)
		{
		return false;
		}
		finally {
			session.close();

		}		
	}
}
