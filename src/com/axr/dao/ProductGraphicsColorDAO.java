package com.axr.dao;

import java.util.List;

import com.axr.model.Product;
import com.axr.model.ProductColor;
import com.axr.model.ProductGraphicsColor;

public interface ProductGraphicsColorDAO {
	public boolean findProductGraphicsColorById(int productColorId);
	public ProductGraphicsColor getProductGraphicsColorById(int productGraphicsColorId);
	public ProductGraphicsColor getDefaultProductGraphicsColor(int productId);
	public List<ProductGraphicsColor> getProductGraphicsColorsByGraphics(int productId, int productGraphicsId);
    public int createProductGraphicsColor(ProductGraphicsColor productGraphicColor);
	public boolean deleteProductGraphicsColor(int productColorId);
	public boolean deleteProductGraphicsColorByProductId(int productId);
	public boolean deleteProductGraphicsColorByGraphicsId(int productGraphicsId);
	boolean updateProductGraphicsColor(ProductGraphicsColor productGraphicColor);
}
