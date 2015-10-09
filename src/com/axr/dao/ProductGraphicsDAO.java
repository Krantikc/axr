package com.axr.dao;

import java.util.List;

import com.axr.model.Product;
import com.axr.model.ProductGraphics;

public interface ProductGraphicsDAO {
	public boolean findProductGraphicsById(int productGraphicsId);
	public ProductGraphics getProductGraphicsById(int productGraphicsId);
	public ProductGraphics getDefaultProductGraphics(int productId);
	public List<ProductGraphics> getProductGraphics(int productId);
    public boolean createProductGraphics(ProductGraphics productGraphics);
	public boolean deleteProductGraphics(int productGraphicsId);
	public boolean deleteProductGraphicsByProductId(int productId);
	boolean updateProductGraphics(ProductGraphics productGraphics);
	List<ProductGraphics> getProductGraphicsByColor(int productId, int colorId);
	boolean deleteProductGraphicsByColorId(int productColorId);
}
