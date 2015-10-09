package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_COLOR")
public class ProductColor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_COLOR_ID")
	private int productColorId;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="NAME")
	private String name;

	@Column(name="IS_DEFAULT_COLOR")
	private boolean isDefaultColor;
	
	public ProductColor() {
		
	}
	
	public ProductColor(int productColorId, int productId, String name, boolean isDefaultColor) {
		this.productColorId = productColorId;
		this.productId = productId;
		this.name = name;
		this.isDefaultColor = isDefaultColor;
	}

	public ProductColor( int productId, String name, boolean isDefaultColor) {
		this.productId = productId;
		this.name = name;
		this.isDefaultColor = isDefaultColor;
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

	public boolean isDefaultColor() {
		return isDefaultColor;
	}

	public void setDefaultColor(boolean isDefaultColor) {
		this.isDefaultColor = isDefaultColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
