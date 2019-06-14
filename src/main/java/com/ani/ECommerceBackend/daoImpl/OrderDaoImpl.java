package com.ani.ECommerceBackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ani.ECommerceBackend.dao.OrderDao;
import com.ani.ECommerceBackend.model.Cart;
import com.ani.ECommerceBackend.model.UserOrder;
@Component
public class OrderDaoImpl implements OrderDao {

	@Autowired
	SessionFactory factory;
	
	public boolean saveOrder(UserOrder userOrder) {
		
           Session session =factory.openSession();
            session.save(userOrder);
            try
            {
        Transaction transaction= session.beginTransaction();
        transaction.commit();
            }
            catch(Exception e)
            {
            	e.printStackTrace();
         System.out.println("catch");
            }  
            finally {
    			session.close();

    		}
         return true;
        
               }	
	

	public List<UserOrder> getMyOrders(String userName) {
		Session session=factory.openSession();
		Query query=session.createQuery("from UserOrder where user.email=:em");
		query.setParameter("em", userName);
		List<UserOrder> orderList=query.list();
		Transaction transaction= session.beginTransaction();
        transaction.commit();
        session.close();
		return orderList;
	}

}
