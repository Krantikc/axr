package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_GRAPHICS_COLOR")
public class ProductGraphicsColor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_GRAPHICS_COLOR_ID")
	private int productGraphicsColorId;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="PRODUCT_GRAPHICS_ID")
	private int productGraphicsId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="IS_DEFAULT_GRAPHICS_COLOR")
	private boolean isDefaultGraphicsColor;
	
	public ProductGraphicsColor() {
		
	}
	
	public ProductGraphicsColor(int productId, int graphicsId, String name, boolean isDefaultGraphicsColor) {
		this.productId = productId;
		this.productGraphicsId = graphicsId;
		this.name = name;
		this.isDefaultGraphicsColor = isDefaultGraphicsColor;
	}

	public ProductGraphicsColor(int id, int productId, int graphicsId, String name, boolean isDefaultGraphicsColor) {
		this.productGraphicsColorId = id;
		this.productId = productId;
		this.productGraphicsId = graphicsId;
		this.name = name;
		this.isDefaultGraphicsColor = isDefaultGraphicsColor;
	}
	
	public int getProductGraphicsColorId() {
		return productGraphicsColorId;
	}

	public void setProductGraphicsColorId(int productGraphicsColorId) {
		this.productGraphicsColorId = productGraphicsColorId;
	}

	public int getProductId() {
		return productId;
	}
 
	public int getProductGraphicsId() {
		return productGraphicsId;
	}

	public void setProductGraphicsId(int productGraphicsId) {
		this.productGraphicsId = productGraphicsId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDefaultGraphicsColor() {
		return isDefaultGraphicsColor;
	}

	public void setDefaultGraphicsColor(boolean isDefaultGraphicsColor) {
		this.isDefaultGraphicsColor = isDefaultGraphicsColor;
	}

	
}
