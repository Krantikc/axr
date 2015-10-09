package com.axr.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Transient
	private List<ProductColor> colors;
	
	@Transient
	private ProductColor defaultColor;
	
	@Transient
	private List<ProductFeature> features;
	
	@Transient
	private List<ProductGraphics> graphics;
	
	@Transient
	private ProductGraphics defaultGraphics;
	
	@Transient
	private List<ProductGraphicsColor> graphicsColors;

	@Transient
	private ProductGraphicsColor defaultGraphicsColor;

	public Product() {
		
	}
	public Product( String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Product(int productId, String name, String description) {
		this.productId = productId;
		this.name = name;
		this.description = description;
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

	public List<ProductColor> getColors() {
		return colors;
	}

	public void setColors(List<ProductColor> colors) {
		this.colors = colors;
	}

	public ProductColor getDefaultColor() {
		return defaultColor;
	}

	public void setDefaultColor(ProductColor defaultColor) {
		this.defaultColor = defaultColor;
	}

	public List<ProductFeature> getFeatures() {
		return features;
	}

	public void setFeatures(List<ProductFeature> features) {
		this.features = features;
	}

	public List<ProductGraphics> getGraphics() {
		return graphics;
	}

	public void setGraphics(List<ProductGraphics> graphics) {
		this.graphics = graphics;
	}

	public ProductGraphics getDefaultGraphics() {
		return defaultGraphics;
	}

	public void setDefaultGraphics(ProductGraphics defaultGraphics) {
		this.defaultGraphics = defaultGraphics;
	}

	public List<ProductGraphicsColor> getGraphicsColors() {
		return graphicsColors;
	}

	public void setGraphicsColors(List<ProductGraphicsColor> graphicsColors) {
		this.graphicsColors = graphicsColors;
	}

	public ProductGraphicsColor getDefaultGraphicsColor() {
		return defaultGraphicsColor;
	}

	public void setDefaultGraphicsColors(ProductGraphicsColor defaultGraphicsColor) {
		this.defaultGraphicsColor = defaultGraphicsColor;
	}

	
	
	
	
}
