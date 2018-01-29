package com.pwi.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.pwi.dto.StockDTO;
import com.pwi.entity.StockSummary;

@Repository
public class InventoryDAO extends AbstractDAO<Integer,StockSummary> {

	@SuppressWarnings("unchecked")
	public void updateProductStock(int productID, StockDTO stockDTO) {
		String hql = "from StockSummary ss where ss.productWarehous.productAttribute.product.productId=:productId";
		Query query = getSession().createQuery(hql);
		query.setInteger("productId", productID);
		
		List<StockSummary> list =  query.list();
		for(StockSummary stock : list) {
			stock.setAvailableQuantity(stock.getAvailableQuantity() + stockDTO.getAvailableQuantity());
			
			getSession().saveOrUpdate(stock);
		}
	}

	public void updateProductStockByWarehouse(int productID, int warehouseID, StockDTO stockDTO) {
		String hql = "from StockSummary ss where ss.productWarehous.productAttribute.product.productId=:productId and ss.productWarehous.warehouse.warehouseId = :warehouseId";
		Query query = getSession().createQuery(hql);
		query.setInteger("productId", productID);
		query.setInteger("warehouseId", warehouseID);
		
		@SuppressWarnings("unchecked")
		List<StockSummary> list =  query.list();
		for(StockSummary stock : list) {
			stock.setAvailableQuantity(stock.getAvailableQuantity() + stockDTO.getAvailableQuantity());
			
			getSession().saveOrUpdate(stock);
		}
		
	}
}
