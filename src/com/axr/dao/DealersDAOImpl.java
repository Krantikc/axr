package com.axr.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.axr.model.Component;
import com.axr.model.Dealer;
import com.axr.util.HibernateUtil;

public class DealersDAOImpl implements DealersDAO {
	SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	@Override
	public boolean updateDealer(Dealer dealer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(dealer);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public int createDealer(Dealer dealer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int dealerId = (Integer) session.save(dealer);
		session.getTransaction().commit();
		session.close();
		return dealerId;
	}

	@Override
	public List<Dealer> getDealers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Dealer> dealers = session.createCriteria(Dealer.class).list();
		session.getTransaction().commit();
		session.close();
		return dealers;
	}

	@Override
	public boolean deleteDealer(int dealerId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Dealer dealer = (Dealer) session.load(Dealer.class, dealerId);
		session.delete(dealer);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

}
