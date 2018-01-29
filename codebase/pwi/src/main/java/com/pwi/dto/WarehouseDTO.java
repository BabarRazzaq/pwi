package com.pwi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class WarehouseDTO {

	private int warehouseId;
	private int countryId;
	private String address;
	private int isDeleted;
	private String name;
	private String countryName;
	
	public WarehouseDTO() {
		
	}
	
	public WarehouseDTO(int warehouseId, String address, int isDeleted, String name, String countryName) {
		this.warehouseId = warehouseId;
		this.address = address;
		this.isDeleted = isDeleted;
		this.name = name;
		this.countryName = countryName;
	}
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	@JsonProperty(access = Access.WRITE_ONLY)
	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonIgnore
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
