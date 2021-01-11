package com.nguyenchiphong.dto;

import java.util.UUID;

public class SalesDTO extends BaseDTO<SalesDTO> {

	private UUID product_id;
	private UUID location_id;
	private UUID time_id;
	private Integer dollars;
	
	public UUID getProduct_id() {
		return product_id;
	}
	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}
	public UUID getLocation_id() {
		return location_id;
	}
	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}
	public UUID getTime_id() {
		return time_id;
	}
	public void setTime_id(UUID time_id) {
		this.time_id = time_id;
	}
	public Integer getDollars() {
		return dollars;
	}
	public void setDollars(Integer dollars) {
		this.dollars = dollars;
	}
	
}
