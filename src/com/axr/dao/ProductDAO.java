package com.axr.dao;

import java.util.List;

import com.axr.model.DefaultProducts;
import com.axr.model.Product;

public interface ProductDAO {
	public boolean findProductById(int productId);
	public Product getProduct(int productId);
	public Product getDefaultProduct(int modelId);
	public List<Product> getAllProducts();
	public List<Product> getProductsByModel(int modelId);
    public boolean createProduct(Product product);
	public boolean deleteProduct(int productId);
	boolean updateProduct(Product product);
}
