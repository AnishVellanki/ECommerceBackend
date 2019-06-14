package com.ani.ECommerceBackend.daoImpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.ECommerceBackend.model.ShippingAddress;

@Component
public class ShippingAddressDaoImpl {

	@Autowired
	SessionFactory factory;
	
	public boolean addShipAddress(ShippingAddress address)
	{
		Session session=factory.openSession();
		session.save(address);
		try
		{
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		return true;
		}
		catch (Exception e) {
			return false;
		} 
		
		finally {
			session.close();		
		}
	}	

		
			}
	

