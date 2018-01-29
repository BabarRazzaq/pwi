package com.pwi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private int productId;
	private int isDeleted;
	private int minimumOrderQuantity;
	private String name;
	private int quantityPerBox;
	private int reorderPoint;
	private FamilyOfBrand familyOfBrand;
	private ProductType productType;
	private List<ProductAttribute> productAttributes;

	public Product() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}


	@Column(name="is_deleted")
	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}


	@Column(name="minimum_order_quantity")
	public int getMinimumOrderQuantity() {
		return this.minimumOrderQuantity;
	}

	public void setMinimumOrderQuantity(int minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="quantity_per_box")
	public int getQuantityPerBox() {
		return this.quantityPerBox;
	}

	public void setQuantityPerBox(int quantityPerBox) {
		this.quantityPerBox = quantityPerBox;
	}


	@Column(name="reorder_point")
	public int getReorderPoint() {
		return this.reorderPoint;
	}

	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}


	//bi-directional many-to-one association to FamilyOfBrand
	@ManyToOne
	@JoinColumn(name="brand_id")
	public FamilyOfBrand getFamilyOfBrand() {
		return this.familyOfBrand;
	}

	public void setFamilyOfBrand(FamilyOfBrand familyOfBrand) {
		this.familyOfBrand = familyOfBrand;
	}


	//bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name="type_id")
	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}


	//bi-directional many-to-one association to ProductAttribute
	@OneToMany(mappedBy="product")
	public List<ProductAttribute> getProductAttributes() {
		return this.productAttributes;
	}

	public void setProductAttributes(List<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}

	public ProductAttribute addProductAttribute(ProductAttribute productAttribute) {
		getProductAttributes().add(productAttribute);
		productAttribute.setProduct(this);

		return productAttribute;
	}

	public ProductAttribute removeProductAttribute(ProductAttribute productAttribute) {
		getProductAttributes().remove(productAttribute);
		productAttribute.setProduct(null);

		return productAttribute;
	}

}