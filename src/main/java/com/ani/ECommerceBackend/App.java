package com.ani.ECommerceBackend;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context= new ClassPathXmlApplicationContext("dBConfig.xml");
    	SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");
        System.out.println( "Hello World!"+sessionFactory );
    }
}
