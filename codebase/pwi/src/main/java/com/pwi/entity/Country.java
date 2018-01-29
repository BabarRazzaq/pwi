package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	private int countryId;
	private String countryName;
	private List<Warehouse> warehouses;

	public Country() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="country_id")
	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}


	@Column(name="country_name")
	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	//bi-directional many-to-one association to Warehouse
	@OneToMany(mappedBy="country")
	public List<Warehouse> getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public Warehouse addWarehous(Warehouse warehous) {
		getWarehouses().add(warehous);
		warehous.setCountry(this);

		return warehous;
	}

	public Warehouse removeWarehous(Warehouse warehous) {
		getWarehouses().remove(warehous);
		warehous.setCountry(null);

		return warehous;
	}

}