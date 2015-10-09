package com.axr.dao;

import java.util.List;

import com.axr.model.ProductColor;
import com.axr.model.ProductFeature;

public interface ProductFeatureDAO {
	public boolean findProductFeatureById(int productFeatureId);
	public ProductFeature getProductFeature(int productFeatureId);
	public ProductFeature getDefaultProductFeature(int productId);
	public List<ProductFeature> getProductFeatures(int productId);
    public int createProductFeature(ProductFeature productFeature);
	public boolean deleteProductFeature(int productFeatureId);
	public boolean deleteProductFeatureByProductId(int productId);
	boolean updateProductFeature(ProductFeature productFeature);
}
