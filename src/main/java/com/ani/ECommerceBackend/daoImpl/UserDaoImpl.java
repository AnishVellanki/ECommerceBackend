package com.ani.ECommerceBackend.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.ECommerceBackend.dao.UserDao;
import com.ani.ECommerceBackend.model.Product;
import com.ani.ECommerceBackend.model.ShippingAddress;
import com.ani.ECommerceBackend.model.User;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao
{
@Autowired
SessionFactory factory;
	
	public boolean addUser(User user) {
	
		Session session= factory.openSession();
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		//ShippingAddress address= user.getAddress();
		//System.out.println("~~~~~~~~~~~~~~"+address);
		//user.setAddress(address);
		session.save(user);
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
	

	public boolean checkLogin(User user) {
		Session session=factory.openSession();
		Query query=session.createQuery("from User where email=:em and password=:pw");
		query.setParameter("em",user.getEmail());
		query.setParameter("pw",user.getPassword());
		System.out.println("after cast");
		User user1=(User)query.uniqueResult();
		
		System.out.println("after cast");
		if(user1==null)
		{
			return false;
		}
		else
		{
			return true;
		}

	}

	public User getUser(String email) {
		Session session= factory.openSession();	
		User user=session.get(User.class, email);
		session.close();
		return user;
	}

		
}
