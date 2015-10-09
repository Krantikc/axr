package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GRAPHIC")
public class Graphic {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GRAPHIC_ID")
	private int graphicId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="IMAGE")
	private String image;

	public int getGraphicId() {
		return graphicId;
	}

	public void setGraphicId(int graphicId) {
		this.graphicId = graphicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
