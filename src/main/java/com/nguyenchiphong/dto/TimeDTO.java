package com.nguyenchiphong.dto;

public class TimeDTO extends BaseDTO<TimeDTO> {
	
	private Integer month;
	private Integer quater;
	private Integer year;
	
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
