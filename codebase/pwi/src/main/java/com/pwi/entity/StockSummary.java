package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stock_summary database table.
 * 
 */
@Entity
@Table(name="stock_summary")
@NamedQuery(name="StockSummary.findAll", query="SELECT s FROM StockSummary s")
public class StockSummary implements Serializable {
	private static final long serialVersionUID = 1L;
	private long summaryId;
	private long availableQuantity;
	private long inStock;
	private long inTransit;
	private ProductWarehous productWarehous;

	public StockSummary() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="summary_id")
	public long getSummaryId() {
		return this.summaryId;
	}

	public void setSummaryId(long summaryId) {
		this.summaryId = summaryId;
	}


	@Column(name="available_quantity")
	public long getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}


	@Column(name="in_stock")
	public long getInStock() {
		return this.inStock;
	}

	public void setInStock(long inStock) {
		this.inStock = inStock;
	}


	@Column(name="in_transit")
	public long getInTransit() {
		return this.inTransit;
	}

	public void setInTransit(long inTransit) {
		this.inTransit = inTransit;
	}


	//bi-directional many-to-one association to ProductWarehous
	@ManyToOne
	@JoinColumn(name="product_warehouse_id")
	public ProductWarehous getProductWarehous() {
		return this.productWarehous;
	}

	public void setProductWarehous(ProductWarehous productWarehous) {
		this.productWarehous = productWarehous;
	}

}