package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LATEST_DESIGN")
public class LatestDesign {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LATEST_DESIGN_ID")
	private int latestDesignId;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="COLOR_ID")
	private int colorId;
	
	@Column(name="GRAPHICS_ID")
	private int graphicsId;
	
	@Column(name="GRAPHICS_COLOR_ID")
	private int graphicsColorId;
	
	public LatestDesign() {
		
	}
	
	public LatestDesign(int productId, int colorId, int graphicsId, int graphicsColorId) {
		this.productId = productId;
		this.colorId = colorId;
		this.graphicsId = graphicsId;
		this.graphicsColorId = graphicsColorId;
	}

	public int getLatestDesignId() {
		return latestDesignId;
	}

	public void setLatestDesignId(int latestDesignId) {
		this.latestDesignId = latestDesignId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getGraphicsId() {
		return graphicsId;
	}

	public void setGraphicsId(int graphicsId) {
		this.graphicsId = graphicsId;
	}

	public int getGraphicsColorId() {
		return graphicsColorId;
	}

	public void setGraphicsColorId(int graphicsColorId) {
		this.graphicsColorId = graphicsColorId;
	}

}
