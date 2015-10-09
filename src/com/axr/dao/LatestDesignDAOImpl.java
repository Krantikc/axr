package com.axr.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.axr.model.LatestDesign;
import com.axr.model.Product;
import com.axr.model.ProductColor;
import com.axr.util.HibernateUtil;

public class LatestDesignDAOImpl implements LatestDesignDAO {
	SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	
	@Override
	public boolean findLatestDesignById(int latestDesignId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		LatestDesign latestDesign = (LatestDesign) session.createCriteria(LatestDesign.class).add(Restrictions.eq("latestDesignId",latestDesignId)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		if(latestDesign!=null) {
			return true;
		}
		return false;
	}

	@Override
	public int createLatestDesign(LatestDesign latestDesign) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int latestDesignId = (Integer) session.save(latestDesign);
		session.getTransaction().commit();
		session.close();
		return latestDesignId;
	}

	@Override
	public boolean deleteLatestDesignById(int latestDesignId) {
		boolean isLatestDesignAvailable = new LatestDesignDAOImpl().findLatestDesignById(latestDesignId);
		if(isLatestDesignAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			LatestDesign latestDesign = (LatestDesign) session.load(LatestDesign.class, latestDesignId);
			session.delete(latestDesign);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public List<LatestDesign> getLatestDesigns() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<LatestDesign> latestDesigns = session.createCriteria(LatestDesign.class).list();
		session.getTransaction().commit();
		session.close();
		return latestDesigns;
	}

}
