package com.axr.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.axr.model.Block;
import com.axr.util.HibernateUtil;

public class BlockDAOImpl implements BlockDAO{
	SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	
	@Override
	public List<Block> getBlocks() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Block> blocks = session.createCriteria(Block.class).list();
		session.getTransaction().commit();
		session.close();
		return blocks;
	}
	
	@Override
	public boolean updateBlock(Block block) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(block);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public int createBlock(Block block) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int blockId = (Integer) session.save(block);
		session.getTransaction().commit();
		session.close();
		return blockId;
	}

}
