package com.axr.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.axr.model.UserLogin;
import com.axr.util.HibernateUtil;


public class UserLoginDAOImpl implements UserLoginDAO{
SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	@Override
	public UserLogin getUserLoginByCredentials(String username, String password) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserLogin userLogin = (UserLogin) session.createCriteria(UserLogin.class).add(Restrictions.eq("username",username)).add(Restrictions.eq("password",password)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return userLogin;
	}

	@Override
	public UserLogin getUserLoginByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
