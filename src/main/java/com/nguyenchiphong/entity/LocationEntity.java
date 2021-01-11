package com.nguyenchiphong.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
public class LocationEntity extends BaseEntity {

	@Column
	private String country;

	@Column
	private String city;

	// set relation:
	@OneToMany(mappedBy = "locationEntity")
	private List<SalesEntity> lstSales = new ArrayList<>();

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
