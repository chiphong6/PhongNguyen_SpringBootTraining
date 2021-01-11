package com.nguyenchiphong.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Time")
public class TimeEntity extends BaseEntity {

	@Column
	private Integer month;

	@Column
	private Integer quater;

	@Column
	private Integer year;

	// set relation:
	@OneToMany(mappedBy = "timeEntity")
	private List<SalesEntity> lstSales = new ArrayList<>();

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getQuater() {
		return quater;
	}

	public void setQuater(Integer quater) {
		this.quater = quater;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
