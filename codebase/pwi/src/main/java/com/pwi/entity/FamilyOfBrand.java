package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the family_of_brands database table.
 * 
 */
@Entity
@Table(name="family_of_brands")
@NamedQuery(name="FamilyOfBrand.findAll", query="SELECT f FROM FamilyOfBrand f")
public class FamilyOfBrand implements Serializable {
	private static final long serialVersionUID = 1L;
	private int brandId;
	private String brandCode;
	private String brandName;
	private List<Product> products;

	public FamilyOfBrand() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="brand_id")
	public int getBrandId() {
		return this.brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}


	@Column(name="brand_code")
	public String getBrandCode() {
		return this.brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}


	@Column(name="brand_name")
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="familyOfBrand")
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setFamilyOfBrand(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setFamilyOfBrand(null);

		return product;
	}

}