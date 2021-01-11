package com.nguyenchiphong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sales")
public class SalesEntity extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private LocationEntity locationEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "time_id")
	private TimeEntity timeEntity;
	
	@Column
	private Integer dollars;

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public LocationEntity getLocationEntity() {
		return locationEntity;
	}

	public void setLocationEntity(LocationEntity locationEntity) {
		this.locationEntity = locationEntity;
	}

	public TimeEntity getTimeEntity() {
		return timeEntity;
	}

	public void setTimeEntity(TimeEntity timeEntity) {
		this.timeEntity = timeEntity;
	}

	public Integer getDollars() {
		return dollars;
	}

	public void setDollars(Integer dollars) {
		this.dollars = dollars;
	}
		
}
