package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_GRAPHICS")
public class ProductGraphics {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_GRAPHICS_ID")
	private int productGraphicsId;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="PRODUCT_COLOR_ID")
	private int productColorId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="IS_DEFAULT_GRAPHICS")
	private boolean isDefaultGraphics;

	public ProductGraphics() {
		
	}
	
	public ProductGraphics(int productGraphicsId, int productId, int productColorId, String name, boolean isDefaultGraphics) {
		this.productGraphicsId = productGraphicsId;
		this.productId = productId;
		this.productColorId = productColorId;
		this.name = name;
		this.isDefaultGraphics = isDefaultGraphics;
	}
	
	public ProductGraphics(int productId, int productColorId, String name, boolean isDefaultGraphics) {
		this.productId = productId;
		this.productColorId = productColorId;
		this.name = name;
		this.isDefaultGraphics = isDefaultGraphics;
	}
	
	public int getProductGraphicsId() {
		return productGraphicsId;
	}

	public void setProductGraphicsId(int productGraphicsId) {
		this.productGraphicsId = productGraphicsId;
	}

	public int getProductColorId() {
		return productColorId;
	}

	public void setProductColorId(int productColorId) {
		this.productColorId = productColorId;
	}

	public int getProductId() {
		return productId;
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

	public boolean isDefaultGraphics() {
		return isDefaultGraphics;
	}

	public void setDefaultGraphics(boolean isDefaultGraphics) {
		this.isDefaultGraphics = isDefaultGraphics;
	}

	

}
