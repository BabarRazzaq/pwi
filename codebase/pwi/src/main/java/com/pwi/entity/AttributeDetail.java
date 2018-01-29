package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the attribute_details database table.
 * 
 */
@Entity
@Table(name="attribute_details")
@NamedQuery(name="AttributeDetail.findAll", query="SELECT a FROM AttributeDetail a")
public class AttributeDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int detailId;
	private String name;
	private Attribute attribute;
	private List<ProductAttribute> productAttributes;

	public AttributeDetail() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="detail_id")
	public int getDetailId() {
		return this.detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Attribute
	@ManyToOne
	@JoinColumn(name="attr_id")
	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}


	//bi-directional many-to-one association to ProductAttribute
	@OneToMany(mappedBy="attributeDetail")
	public List<ProductAttribute> getProductAttributes() {
		return this.productAttributes;
	}

	public void setProductAttributes(List<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}

	public ProductAttribute addProductAttribute(ProductAttribute productAttribute) {
		getProductAttributes().add(productAttribute);
		productAttribute.setAttributeDetail(this);

		return productAttribute;
	}

	public ProductAttribute removeProductAttribute(ProductAttribute productAttribute) {
		getProductAttributes().remove(productAttribute);
		productAttribute.setAttributeDetail(null);

		return productAttribute;
	}

}