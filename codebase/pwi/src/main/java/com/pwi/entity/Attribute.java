package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the attributes database table.
 * 
 */
@Entity
@Table(name="attributes")
@NamedQuery(name="Attribute.findAll", query="SELECT a FROM Attribute a")
public class Attribute implements Serializable {
	private static final long serialVersionUID = 1L;
	private int attrId;
	private String name;
	private List<AttributeDetail> attributeDetails;

	public Attribute() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="attr_id")
	public int getAttrId() {
		return this.attrId;
	}

	public void setAttrId(int attrId) {
		this.attrId = attrId;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to AttributeDetail
	@OneToMany(mappedBy="attribute")
	public List<AttributeDetail> getAttributeDetails() {
		return this.attributeDetails;
	}

	public void setAttributeDetails(List<AttributeDetail> attributeDetails) {
		this.attributeDetails = attributeDetails;
	}

	public AttributeDetail addAttributeDetail(AttributeDetail attributeDetail) {
		getAttributeDetails().add(attributeDetail);
		attributeDetail.setAttribute(this);

		return attributeDetail;
	}

	public AttributeDetail removeAttributeDetail(AttributeDetail attributeDetail) {
		getAttributeDetails().remove(attributeDetail);
		attributeDetail.setAttribute(null);

		return attributeDetail;
	}

}