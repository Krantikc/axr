package com.axr.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.axr.model.Block;
import com.axr.model.Component;
import com.axr.util.HibernateUtil;

public class ComponentDAOImpl implements ComponentDAO{
	SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	@Override
	public boolean updateComponent(Component component) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(component);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public int createComponent(Component component) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Component> getComponents() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Component> components = session.createCriteria(Component.class).list();
		session.getTransaction().commit();
		session.close();
		return components;
	}

}
