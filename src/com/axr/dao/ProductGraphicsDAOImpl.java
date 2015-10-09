package com.axr.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.axr.model.ProductColor;
import com.axr.model.ProductFeature;
import com.axr.model.ProductGraphics;
import com.axr.util.HibernateUtil;

public class ProductGraphicsDAOImpl implements ProductGraphicsDAO {

	SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	
	@Override
	public boolean findProductGraphicsById(int productGraphicsId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ProductGraphics productGraphics = (ProductGraphics) session.createCriteria(ProductGraphics.class).add(Restrictions.eq("productGraphicsId",productGraphicsId)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		if(productGraphics!=null) {
			return true;
		}
		return false;
	}

	@Override
	public ProductGraphics getProductGraphicsById(int productGraphicsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductGraphics getDefaultProductGraphics(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductGraphics> getProductGraphics(int productId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<ProductGraphics> productGraphics = session.createCriteria(ProductGraphics.class).add(Restrictions.eq("productId",productId)).list();
		session.getTransaction().commit();
		session.close();
		return productGraphics;
	}

	@Override
	public boolean createProductGraphics(ProductGraphics productGraphics) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(productGraphics);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteProductGraphics(int productGraphicsId) {
		boolean isProductGraphicsAvailable = new ProductGraphicsDAOImpl().findProductGraphicsById(productGraphicsId);
		if(isProductGraphicsAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			ProductGraphics productGraphics = (ProductGraphics) session.load(ProductGraphics.class, productGraphicsId);
			session.delete(productGraphics);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProductGraphics(ProductGraphics productGraphics) {
		boolean isProductGraphicsAvailable = new ProductGraphicsDAOImpl().findProductGraphicsById(productGraphics.getProductGraphicsId());
		if(isProductGraphicsAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(productGraphics);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public List<ProductGraphics> getProductGraphicsByColor(int productId,
			int colorId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<ProductGraphics> productGraphics = session.createCriteria(ProductGraphics.class).add(Restrictions.eq("productId", productId))
													 .add(Restrictions.eq("productColorId", colorId)).list();
		session.getTransaction().commit();
		session.close();
		return productGraphics; 
		
	}
	
	public boolean setOthersAsNonDefaultProductGraphics(int productId, int productColorId) {
		String hql = "update ProductGraphics set isDefaultGraphics=0 where productId=:productId AND productColorId=:productColorId";
		boolean isProductAvailable = new ProductDAOImpl().findProductById(productId);
		if(isProductAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setInteger("productId", productId);
			query.setInteger("productColorId", productColorId);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}

	public boolean setAsDefaultProductGraphics(int productId, int productGraphicsId) {
		String hql = "update ProductGraphics set isDefaultGraphics=1 where productId=:productId AND productGraphicsId=:productGraphicsId";
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
	
	@Override
	public boolean deleteProductGraphicsByProductId(int productId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from ProductGraphics where productId="+productId);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;

	}
	
	@Override
	public boolean deleteProductGraphicsByColorId(int productColorId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from ProductGraphics where productColorId="+productColorId);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;

	}

}
