package com.axr.util;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.axr.model.Enquiry;
import com.axr.model.ProductGraphicsColor;

public class EnquiryUtil {
SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	
	public boolean createEnquiry(Enquiry enquiry) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(enquiry);
		session.getTransaction().commit();
		session.close();
		return true;
	}


}
