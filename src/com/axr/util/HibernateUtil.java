package com.axr.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static final SessionFactory sessionFactory=buildSessionFactory();
	public SessionFactory getSessionFactory(){
		
		return sessionFactory;	
	}
	private static SessionFactory buildSessionFactory() {
		
			return new Configuration().configure().buildSessionFactory();
		
		
	}

}
