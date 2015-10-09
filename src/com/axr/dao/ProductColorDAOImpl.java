package com.axr.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.axr.model.Product;
import com.axr.model.ProductColor;
import com.axr.util.HibernateUtil;

public class ProductColorDAOImpl implements ProductColorDAO {
	SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	
	@Override
	public boolean findProductColorById(int productColorId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ProductColor productColor = (ProductColor) session.createCriteria(ProductColor.class).add(Restrictions.eq("productColorId",productColorId)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		if(productColor!=null) {
			return true;
		}
		return false;
	}

	@Override
	public ProductColor getProductColor(int productColorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductColor getDefaultProductColor(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductColor> getProductColors(int productId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<ProductColor> productColors = session.createCriteria(ProductColor.class).add(Restrictions.eq("productId",productId)).list();
		session.getTransaction().commit();
		session.close();
		return productColors;
	}

	@Override
	public boolean createProductColor(ProductColor productColor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(productColor);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteProductColor(int productColorId) {
		boolean isProductColorAvailable = new ProductColorDAOImpl().findProductColorById(productColorId);
		if(isProductColorAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			ProductColor productColor = (ProductColor) session.load(ProductColor.class, productColorId);
			session.delete(productColor);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProductColor(ProductColor productColor) {
		boolean isProductColorAvailable = new ProductColorDAOImpl().findProductColorById(productColor.getProductColorId());
		if(isProductColorAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(productColor);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}
	
	public boolean setOthersAsNonDefaultProductColor(int productId) {
		String hql = "update ProductColor set isDefaultColor=0 where productId=:productId";
		boolean isProductAvailable = new ProductDAOImpl().findProductById(productId);
		if(isProductAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setInteger("productId", productId);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}

	public boolean setAsDefaultProductColor(int productId, int productColorId) {
		String hql = "update ProductColor set isDefaultColor=1 where productId=:productId AND productColorId=:productColorId";
		boolean isProductColorAvailable = new ProductColorDAOImpl().findProductColorById(productColorId);
		if(isProductColorAvailable) {
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

	@Override
	public boolean deleteProductColorByProductId(int productId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from ProductColor where productId="+productId);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;
	}

}
