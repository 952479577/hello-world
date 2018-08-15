package com.yc.bean;

public class House {
	private Integer id;
	
	private String title;
	private String description;
	private Double price;
	private String pubata; 
	private Integer floorage ;    
	private String contact ; 
	
	private Integer user_id;
	private Integer type_id;
	private Integer street_id;
	
	
	public Integer getStreet_id() {
		return street_id;
	}
	public void setStreet_id(Integer street_id) {
		this.street_id = street_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", pubata=" + pubata + ", floorage=" + floorage + ", contact=" + contact + ", user_id=" + user_id
				+ ", type_id=" + type_id + ", street_id=" + street_id + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPubata() {
		return pubata;
	}
	public void setPubata(String pubata) {
		this.pubata = pubata;
	}
	public Integer getFloorage() {
		return floorage;
	}
	public void setFloorage(Integer floorage) {
		this.floorage = floorage;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
