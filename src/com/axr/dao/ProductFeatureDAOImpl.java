package com.axr.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.axr.model.ProductColor;
import com.axr.model.ProductFeature;
import com.axr.util.HibernateUtil;

public class ProductFeatureDAOImpl implements ProductFeatureDAO {

	SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	
	@Override
	public boolean findProductFeatureById(int productFeatureId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ProductFeature productFeature = (ProductFeature) session.createCriteria(ProductFeature.class).add(Restrictions.eq("productFeatureId", productFeatureId)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		if(productFeature!=null) {
			return true;
		}
		return false;
	}

	@Override
	public ProductFeature getProductFeature(int productFeatureId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductFeature getDefaultProductFeature(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductFeature> getProductFeatures(int productId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<ProductFeature> productFeatures = session.createCriteria(ProductFeature.class).add(Restrictions.eq("productId",productId)).list();
		session.getTransaction().commit();
		session.close();
		return productFeatures;
	}

	@Override
	public int createProductFeature(ProductFeature productFeature) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int productFeatureId = (Integer) session.save(productFeature);
		session.getTransaction().commit();
		session.close();
		return productFeatureId;
	}

	@Override
	public boolean deleteProductFeature(int productFeatureId) {
		boolean isProductFeatureAvailable = new ProductFeatureDAOImpl().findProductFeatureById(productFeatureId);
		if(isProductFeatureAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			ProductFeature productFeature = (ProductFeature) session.load(ProductFeature.class, productFeatureId);
			session.delete(productFeature);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProductFeature(ProductFeature productFeature) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteProductFeatureByProductId(int productId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from ProductFeature where productId="+productId);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;

	}

}
