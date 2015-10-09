package com.axr.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.axr.model.ProductColor;
import com.axr.model.ProductGraphics;
import com.axr.model.ProductGraphicsColor;
import com.axr.util.HibernateUtil;

public class ProductGraphicsColorDAOImpl implements ProductGraphicsColorDAO {

	SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	
	@Override
	public boolean findProductGraphicsColorById(int productGraphicsColorId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ProductGraphicsColor productGraphicsColor = (ProductGraphicsColor) session.createCriteria(ProductGraphicsColor.class).add(Restrictions.eq("productGraphicsColorId",productGraphicsColorId)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		if(productGraphicsColor!=null) {
			return true;
		}
		return false;
	}

	@Override
	public ProductGraphicsColor getProductGraphicsColorById(int productGraphicsColorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductGraphicsColor getDefaultProductGraphicsColor(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductGraphicsColor> getProductGraphicsColorsByGraphics(int productId, int productGraphicsId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<ProductGraphicsColor> productGraphicsColor = session.createCriteria(ProductGraphicsColor.class).
														  add(Restrictions.eq("productId",productId)).
														  add(Restrictions.eq("productGraphicsId", productGraphicsId)).
														  list();
		session.getTransaction().commit();
		session.close();
		return productGraphicsColor;
	}

	@Override
	public int createProductGraphicsColor(
			ProductGraphicsColor productGraphicsColor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int graphicsColorId = (Integer) session.save(productGraphicsColor);
		session.getTransaction().commit();
		session.close();
		return graphicsColorId;
	}

	@Override
	public boolean deleteProductGraphicsColor(int productGraphicsColorId) {
		boolean isProductGraphicsColorAvailable = new ProductGraphicsColorDAOImpl().findProductGraphicsColorById(productGraphicsColorId);
		if(isProductGraphicsColorAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			ProductGraphicsColor productGraphicsColor = (ProductGraphicsColor) session.load(ProductGraphicsColor.class, productGraphicsColorId);
			session.delete(productGraphicsColor);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProductGraphicsColor(
			ProductGraphicsColor productGraphicsColor) {
		boolean isProductGraphicsColorAvailable = new ProductGraphicsColorDAOImpl().findProductGraphicsColorById(productGraphicsColor.getProductGraphicsColorId());
		if(isProductGraphicsColorAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(productGraphicsColor);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}

	public boolean setOthersAsNonDefaultProductGraphicsColor(int productId,
			int productGraphicsId) {
		String hql = "update ProductGraphicsColor set isDefaultGraphicsColor=0 where productId=:productId and productGraphicsId=:productGraphicsId";
		boolean isProductGraphicsAvailable = new ProductGraphicsDAOImpl().findProductGraphicsById(productGraphicsId);
		if(isProductGraphicsAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setInteger("productId", productId);
			query.setInteger("productGraphicsId", productGraphicsId);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
		
	}

	public boolean setAsDefaultProductGraphicsColor(int productId,
			int productGraphicsColorId) {
		String hql = "update ProductGraphicsColor set isDefaultGraphicsColor=1 where productId=:productId AND productGraphicsColorId=:productGraphicsColorId";
		boolean isProductGraphicsColorAvailable = new ProductGraphicsColorDAOImpl().findProductGraphicsColorById(productGraphicsColorId);
		if(isProductGraphicsColorAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setInteger("productId", productId);
			query.setInteger("productGraphicsColorId", productGraphicsColorId);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
		
	}
	
	@Override
	public boolean deleteProductGraphicsColorByProductId(int productId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from ProductGraphicsColor where productId="+productId);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;

	}
	
	@Override
	public boolean deleteProductGraphicsColorByGraphicsId(int productGraphicsId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from ProductGraphicsColor where productGraphicsId=" + productGraphicsId);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;

	}

}
