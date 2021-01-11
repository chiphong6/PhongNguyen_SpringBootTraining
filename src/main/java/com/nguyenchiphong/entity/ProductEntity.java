package com.nguyenchiphong.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductEntity extends BaseEntity {
	
	@Column
	private Integer item;
	
	@Column
	private String category;
	
	@Column
	private String inventory;

	//set relation:
	@OneToMany(mappedBy = "productEntity")
	private List<SalesEntity> lstSales = new ArrayList<>();
	
	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	
}
