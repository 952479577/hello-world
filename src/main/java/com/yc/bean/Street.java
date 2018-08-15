package com.yc.bean;

public class Street {
	private Integer id;      
	private String name;       
	
	private District district;

	public Street() {
		super();
	}

	public Street(Integer id, String name, District district) {
		super();
		this.id = id;
		this.name = name;
		this.district = district;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "Street [id=" + id + ", name=" + name + ", district=" + district + "]";
	}
	
	
	
}
