package com.axr.dao;

import java.util.List;

import com.axr.model.Product;
import com.axr.model.ProductColor;

public interface ProductColorDAO {
	public boolean findProductColorById(int productColorId);
	public ProductColor getProductColor(int productColorId);
	public ProductColor getDefaultProductColor(int productId);
	public List<ProductColor> getProductColors(int productId);
    public boolean createProductColor(ProductColor productColor);
	boolean updateProductColor(ProductColor productColor);
	boolean deleteProductColor(int productColorId);
	boolean deleteProductColorByProductId(int productId);
}
