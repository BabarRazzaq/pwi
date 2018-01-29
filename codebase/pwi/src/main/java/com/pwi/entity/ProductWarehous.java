package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product_warehouses database table.
 * 
 */
@Entity
@Table(name="product_warehouses")
@NamedQuery(name="ProductWarehous.findAll", query="SELECT p FROM ProductWarehous p")
public class ProductWarehous implements Serializable {
	private static final long serialVersionUID = 1L;
	private int productWarehouseId;
	private ProductAttribute productAttribute;
	private Warehouse warehouse;
	private List<StockSummary> stockSummaries;

	public ProductWarehous() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_warehouse_id")
	public int getProductWarehouseId() {
		return this.productWarehouseId;
	}

	public void setProductWarehouseId(int productWarehouseId) {
		this.productWarehouseId = productWarehouseId;
	}


	//bi-directional many-to-one association to ProductAttribute
	@ManyToOne
	@JoinColumn(name="product_attr_id")
	public ProductAttribute getProductAttribute() {
		return this.productAttribute;
	}

	public void setProductAttribute(ProductAttribute productAttribute) {
		this.productAttribute = productAttribute;
	}


	//bi-directional many-to-one association to Warehouse
	@ManyToOne
	@JoinColumn(name="warehouse_id")
	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}


	//bi-directional many-to-one association to StockSummary
	@OneToMany(mappedBy="productWarehous")
	public List<StockSummary> getStockSummaries() {
		return this.stockSummaries;
	}

	public void setStockSummaries(List<StockSummary> stockSummaries) {
		this.stockSummaries = stockSummaries;
	}

	public StockSummary addStockSummary(StockSummary stockSummary) {
		getStockSummaries().add(stockSummary);
		stockSummary.setProductWarehous(this);

		return stockSummary;
	}

	public StockSummary removeStockSummary(StockSummary stockSummary) {
		getStockSummaries().remove(stockSummary);
		stockSummary.setProductWarehous(null);

		return stockSummary;
	}

}