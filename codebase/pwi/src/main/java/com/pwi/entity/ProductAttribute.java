package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product_attributes database table.
 * 
 */
@Entity
@Table(name="product_attributes")
@NamedQuery(name="ProductAttribute.findAll", query="SELECT p FROM ProductAttribute p")
public class ProductAttribute implements Serializable {
	private static final long serialVersionUID = 1L;
	private int productAttrId;
	private AttributeDetail attributeDetail;
	private Product product;
	private List<ProductWarehous> productWarehouses;

	public ProductAttribute() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_attr_id")
	public int getProductAttrId() {
		return this.productAttrId;
	}

	public void setProductAttrId(int productAttrId) {
		this.productAttrId = productAttrId;
	}


	//bi-directional many-to-one association to AttributeDetail
	@ManyToOne
	@JoinColumn(name="detail_id")
	public AttributeDetail getAttributeDetail() {
		return this.attributeDetail;
	}

	public void setAttributeDetail(AttributeDetail attributeDetail) {
		this.attributeDetail = attributeDetail;
	}


	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	//bi-directional many-to-one association to ProductWarehous
	@OneToMany(mappedBy="productAttribute")
	public List<ProductWarehous> getProductWarehouses() {
		return this.productWarehouses;
	}

	public void setProductWarehouses(List<ProductWarehous> productWarehouses) {
		this.productWarehouses = productWarehouses;
	}

	public ProductWarehous addProductWarehous(ProductWarehous productWarehous) {
		getProductWarehouses().add(productWarehous);
		productWarehous.setProductAttribute(this);

		return productWarehous;
	}

	public ProductWarehous removeProductWarehous(ProductWarehous productWarehous) {
		getProductWarehouses().remove(productWarehous);
		productWarehous.setProductAttribute(null);

		return productWarehous;
	}

}