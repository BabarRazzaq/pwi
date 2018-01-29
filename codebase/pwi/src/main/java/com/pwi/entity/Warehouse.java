package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the warehouse database table.
 * 
 */
@Entity
@NamedQuery(name="Warehouse.findAll", query="SELECT w FROM Warehouse w")
public class Warehouse implements Serializable {
	private static final long serialVersionUID = 1L;
	private int warehouseId;
	private String address;
	private int isDeleted;
	private String name;
	private List<ProductWarehous> productWarehouses;
	private Country country;

	public Warehouse() {
	}


	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="warehouse_id")
	public int getWarehouseId() {
		return this.warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(name="is_deleted")
	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//bi-directional many-to-one association to ProductWarehous
	@OneToMany(mappedBy="warehouse", fetch=FetchType.LAZY)
	public List<ProductWarehous> getProductWarehouses() {
		return this.productWarehouses;
	}

	public void setProductWarehouses(List<ProductWarehous> productWarehouses) {
		this.productWarehouses = productWarehouses;
	}

	public ProductWarehous addProductWarehous(ProductWarehous productWarehous) {
		getProductWarehouses().add(productWarehous);
		productWarehous.setWarehouse(this);

		return productWarehous;
	}

	public ProductWarehous removeProductWarehous(ProductWarehous productWarehous) {
		getProductWarehouses().remove(productWarehous);
		productWarehous.setWarehouse(null);

		return productWarehous;
	}


	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country_id")
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}