package com.axr.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import com.axr.model.DefaultProducts;
import com.axr.model.Product;
import com.axr.util.HibernateUtil;



public class ProductDAOImpl implements ProductDAO {
	
	SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	
	@Override
	public boolean findProductById(int productId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = (Product) session.createCriteria(Product.class).add(Restrictions.eq("productId",productId)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		if(product!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Product getProduct(int productId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = (Product) session.createCriteria(Product.class).add(Restrictions.eq("productId",productId)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return product;
	}

	@Override
	public Product getDefaultProduct(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Product> getAllProducts() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Product> productsList = session.createCriteria(Product.class).list();
		session.getTransaction().commit();
		session.close();
		return productsList;
	}
	


	@Override
	public List<Product> getProductsByModel(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteProduct(int productId) {
		boolean isProductAvailable = new ProductDAOImpl().findProductById(productId);
		if(isProductAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Product product = (Product) session.load(Product.class, productId);
			session.delete(product);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isProductAvailable = new ProductDAOImpl().findProductById(product.getProductId());
		if(isProductAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(product);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}
	
}
