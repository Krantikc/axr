package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BLOCK")
public class Block {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BLOCK_ID")
	private int blockId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="BACKGROUND_COLOR")
	private String backgroundColor;

	@Column(name="BORDER_COLOR")
	private String borderColor;
	
	@Column(name="TITLE_FONT_SIZE")
	private int titleFontSize;
	
	@Column(name="TITLE_FONT_COLOR")
	private String titleFontColor;
	
	@Column(name="DESC_FONT_SIZE")
	private int descFontSize;
	
	@Column(name="DESC_FONT_COLOR")
	private String descFontColor;
	
	

	public Block() {
		
	}
	
	public Block(int blockId, String backgroundColor, String title, String borderColor, int titleFontSize, String titleFontColor, int descFontSize, String descFontColor) {
		this.blockId = blockId;
		this.backgroundColor = backgroundColor;
		this.title = title;
		this.borderColor = borderColor;
		this.titleFontSize = titleFontSize;
		this.titleFontColor = titleFontColor;
		this.descFontSize = descFontSize;
		this.descFontColor = descFontColor;
	}
	
	public Block(String title, String backgroundColor) {
		this.title = title;
		this.backgroundColor = backgroundColor;
	}
	
	
	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public int getTitleFontSize() {
		return titleFontSize;
	}

	public void setTitleFontSize(int titleFontSize) {
		this.titleFontSize = titleFontSize;
	}

	public String getTitleFontColor() {
		return titleFontColor;
	}

	public void setTitleFontColor(String titleFontColor) {
		this.titleFontColor = titleFontColor;
	}

	public int getDescFontSize() {
		return descFontSize;
	}

	public void setDescFontSize(int descFontSize) {
		this.descFontSize = descFontSize;
	}

	public String getDescFontColor() {
		return descFontColor;
	}

	public void setDescFontColor(String descFontColor) {
		this.descFontColor = descFontColor;
	}	
	

}
