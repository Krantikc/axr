package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_FEATURE")
public class ProductFeature {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_FEATURE_ID")
	private int productFeatureId;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="IMG")
	private String img;
	
	public ProductFeature() {
		
	}
	
	public ProductFeature(int productId, String name) {
		this.productId = productId;
		this.name = name;
	}

	public int getProductFeatureId() {
		return productFeatureId;
	}

	public void setProductFeatureId(int productFeatureId) {
		this.productFeatureId = productFeatureId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	

}
