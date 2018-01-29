package com.pwi.dto;

public class StockDTO {
	
	private String warehouse;
	private String attribute;
	private long availableQuantity;
	private long inStock;
	
	
	public StockDTO() {}
	
	public StockDTO(String warehouse, String attribute, long availableQuantity, long inStock) {
		this.warehouse = warehouse;
		this.attribute = attribute;
		this.availableQuantity = availableQuantity;
		this.inStock = inStock;
	}
	public StockDTO(String attribute, long availableQuantity, long inStock) {
		this.attribute = attribute;
		this.availableQuantity = availableQuantity;
		this.inStock = inStock;
	}
	
	public String getWarehouse() {
		return warehouse;
	}
	
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	
	
	public String getAttribute() {
		return attribute;
	}
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	
	public long getAvailableQuantity() {
		return availableQuantity;
	}
	
	public void setAvailableQuantity(long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	
	public long getInStock() {
		return inStock;
	}
	
	public void setInStock(long inStock) {
		this.inStock = inStock;
	}
}
