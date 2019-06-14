package com.ani.ECommerceBackend.daoImpl;

import java.util.List;
import java.util.Random;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.ECommerceBackend.dao.CartDao;
import com.ani.ECommerceBackend.model.Cart;
import com.ani.ECommerceBackend.model.Product;
import com.ani.ECommerceBackend.model.User;

@Component("cartDaoImpl")
public class CartDaoImpl implements CartDao
{
@Autowired
SessionFactory factory;

	public boolean saveCart(Product product, int quantity,String userName) {
		Session session=null;
		
		try
        {
             session=factory.openSession();
		Cart cart=new Cart();
		
		 if(cart.getCartId()==0)
         {
             Random random=new Random();
             cart.setCartId(random.nextInt(10000));
         }
		 
	     cart.setProductId(product.getProductId());
	    cart.setProductName(product.getProductName());
	    cart.setProductPrice(product.getProductPrice());
	    cart.setProductSupplier(product.getProductSupplier());
	    cart.setTotalPrice((cart.getProductPrice())*(quantity));
	   
	    cart.setQuantity(quantity);
	    cart.setUserName(userName);
	    
	    session.save(cart);
        Transaction transaction=session.beginTransaction();
        transaction.commit();
        return true;
    }
    catch (Exception e) {
        
        return false;
    }
    finally
    {
        session.close();
    }

			
	}

	public boolean deleteCart(Cart cart) {
		Session session=factory.openSession();
		session.delete(cart);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return false;
	}

	
	
	public Cart getCart(int cartId) {
		Session session= factory.openSession();	
		Cart cart=session.get(Cart.class, cartId);
		session.close();
		return cart;
		}

	/*public List<Cart> getCartList() {
		Session session=factory.openSession();
		Query query=session.createQuery("from Cart");
		List<Cart> cartList=query.list();
		for(Cart c:cartList)
		{
			System.out.println(c.getProductId());
			System.out.println(c.getProductName());
	
			System.out.println(c.getProductPrice());
		System.out.println(c.getProductSupplier());
		
		}
		return cartList;
	}*/

		public List<Cart> getCartList(String n) {
			Session session=factory.openSession();
			Query query=session.createQuery("from Cart where username=:em");
			query.setParameter("em", n);
			List<Cart> cartList=query.list();
			for(Cart c:cartList)
			{
				System.out.println(c.getProductId());
				System.out.println(c.getProductName());
		
				System.out.println(c.getProductPrice());
			System.out.println(c.getProductSupplier());
	
			}
			return cartList;
		
	}

}
