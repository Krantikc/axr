package com.axr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEALER")
public class Dealer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEALER_ID")
	private int dealerId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="CONTACT")
	private String contact;

	public Dealer() {
		
	}
	
	public Dealer(String name, String address, String contact) {
		this.name = name;
		this.address = address;
		this.contact = contact;
	}
	
	
	public Dealer(int dealerId, String name, String address, String contact) {
		this.dealerId = dealerId;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}
	
	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
