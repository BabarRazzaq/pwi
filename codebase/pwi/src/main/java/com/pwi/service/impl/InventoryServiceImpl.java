package com.pwi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pwi.dao.InventoryDAO;
import com.pwi.dto.StockDTO;
import com.pwi.service.InventoryService;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryDAO inventoryDAO;
	
	@Override
	public void updateProductStock(int productID, StockDTO stockDTO) {
		inventoryDAO.updateProductStock(productID, stockDTO);
	}

	@Override
	public void updateProductStockByWarehouse(int productID, int warehouseID, StockDTO stockDTO) {
		inventoryDAO.updateProductStockByWarehouse(productID, warehouseID, stockDTO);
	}
}
