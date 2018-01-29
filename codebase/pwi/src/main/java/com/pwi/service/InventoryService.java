package com.pwi.service;

import com.pwi.dto.StockDTO;

public interface InventoryService {

	public void updateProductStock(int productID, StockDTO stockDTO);

	public void updateProductStockByWarehouse(int productID, int warehouseID, StockDTO stockDTO);
}
