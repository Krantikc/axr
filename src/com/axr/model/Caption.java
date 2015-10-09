package com.axr.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="CAPTION")

public class Caption implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CAPTION_ID")
	private int captionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SLIDE_ID", nullable = false)
	private Slide slide;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="TRANSITION")
	private String transition;
	
	@Column(name="POSITION")
	private String position;

	
	public int getCaptionId() {
		return captionId;
	}

	public void setCaptionId(int captionId) {
		this.captionId = captionId;
	}


	public Slide getSlide() {
		return slide;
	}

	public void setSlide(Slide slide) {
		this.slide = slide;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTransition() {
		return transition;
	}

	public void setTransition(String transition) {
		this.transition = transition;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
