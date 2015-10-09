package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ENQUIRY")
public class Enquiry {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ENQUIRY_ID")
	private int enquiryId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="MOBILE")
	private String mobile;
	
	@Column(name="MESSAGE")
	private String message;

	public Enquiry() {
		
	}
	
	public Enquiry(String name, String email, String mobile, String message) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.message = message;
	}
	public int getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
