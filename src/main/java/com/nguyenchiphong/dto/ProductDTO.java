package com.nguyenchiphong.dto;

public class ProductDTO extends BaseDTO<ProductDTO> {
	
	private Integer item;
	private String category;
	private String inventory;
	
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
