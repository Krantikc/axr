package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPONENT")
public class Component {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMPONENT_ID")
	private int componentId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BACKGROUND_COLOR")
	private String backgroundColor;
	
	@Column(name="FONT_SIZE")
	private int fontSize;
	
	@Column(name="FONT_COLOR")
	private String fontColor;
	
	@Column(name="FONT_HOVER_COLOR")
	private String fontHoverColor;
	
	@Column(name="HOVER_BORDER_COLOR")
	private String hoverBorderColor;
	
	
	public Component() {
		
	}
	
	public Component(int componentId, String name, String backgroundColor, 
					 int fontSize, String fontColor, String fontHoverColor,
					 String hoverBorderColor) {
		
		this.componentId = componentId;		
		this.name = name;		
		this.backgroundColor = backgroundColor;
		this.fontSize = fontSize;		
		this.fontColor = fontColor;		
		this.fontHoverColor = fontHoverColor;		
		this.hoverBorderColor = hoverBorderColor;			
	}

	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public String getFontHoverColor() {
		return fontHoverColor;
	}

	public void setFontHoverColor(String fontHoverColor) {
		this.fontHoverColor = fontHoverColor;
	}

	public String getHoverBorderColor() {
		return hoverBorderColor;
	}

	public void setHoverBorderColor(String hoverBorderColor) {
		this.hoverBorderColor = hoverBorderColor;
	}



	
}
