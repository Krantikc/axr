package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COLOR")
public class Color {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COLOR_ID")
	private int colorId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="THUMBNAIL")
	private String thumbnail;

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
}
