package com.axr.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="SLIDE")
@JsonIgnoreProperties(value="captions")
public class Slide {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SLIDE_ID")
	private int slideId;
	
	@Column(name="LABEL")
	private String label;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="TRANSITION")
	private String transition;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "slide", cascade = CascadeType.REMOVE)
	private List<Caption> captions;

	public Slide() {
		
	}
	
	public Slide(String label, String image, String transition) {
		this.label = label;
		this.image = image;
		this.transition = transition;
	}
	
	public Slide(int slideId, String label, String image, String transition) {
		this.slideId = slideId;
		this.label = label;
		this.image = image;
		this.transition = transition;
	}
	public int getSlideId() {
		return slideId;
	}

	public void setSlideId(int slideId) {
		this.slideId = slideId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public List<Caption> getCaptions() {
		return captions;
	}

	public void setCaptions(List<Caption> captions) {
		this.captions = captions;
	}
	
	
}
