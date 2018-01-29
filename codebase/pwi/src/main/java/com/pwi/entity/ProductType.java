package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product_type database table.
 * 
 */
@Entity
@Table(name="product_type")
@NamedQuery(name="ProductType.findAll", query="SELECT p FROM ProductType p")
public class ProductType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int typeId;
	private String productType;
	private List<Product> products;

	public ProductType() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="type_id")
	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	@Column(name="product_type")
	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}


	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productType")
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductType(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductType(null);

		return product;
	}

}