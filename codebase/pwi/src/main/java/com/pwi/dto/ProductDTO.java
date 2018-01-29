package com.pwi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


public class ProductDTO {

	private int productId;
	private int brandId;
	private int typeId;
	private int isDeleted;
	private int minimumOrderQuantity;
	private String name;
	private int quantityPerBox;
	private int reorderPoint;
	private String brandName;
	private String productType;
	
	
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(int productId, int isDeleted, int minimumOrderQuantity, String name, int quantityPerBox,
			int reorderPoint, String brandName, String productType) {
		this.productId = productId;
		this.isDeleted = isDeleted;
		this.minimumOrderQuantity = minimumOrderQuantity;
		this.name = name;
		this.quantityPerBox = quantityPerBox;
		this.reorderPoint = reorderPoint;
		this.brandName = brandName;
		this.productType = productType;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@JsonProperty(access=Access.WRITE_ONLY)
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
	@JsonProperty(access=Access.WRITE_ONLY)
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	@JsonIgnore
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public int getMinimumOrderQuantity() {
		return minimumOrderQuantity;
	}
	public void setMinimumOrderQuantity(int minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantityPerBox() {
		return quantityPerBox;
	}
	public void setQuantityPerBox(int quantityPerBox) {
		this.quantityPerBox = quantityPerBox;
	}
	
	public int getReorderPoint() {
		return reorderPoint;
	}
	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
}
