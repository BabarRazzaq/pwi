package com.pwi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pwi.dto.StockDTO;
import com.pwi.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	private final Logger log = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping(value = "/stock/{productId}", method = RequestMethod.PUT)
    public void updateProductStock(@PathVariable("productId") int productID, @RequestBody StockDTO stockDTO) {
		log.info("Update Stock By Product URL Call");
		inventoryService.updateProductStock(productID, stockDTO);
    }

	@RequestMapping(value = "/stock/{productId}/warehouse/{warehouseId}", method = RequestMethod.PUT)
    public void updateProductStockByWarehouse(@PathVariable("productId") int productID, @PathVariable("warehouseId") int warehouseID, @RequestBody StockDTO stockDTO) {
		log.info("Update Stock By Product and Warehouse URL Call");
		inventoryService.updateProductStockByWarehouse(productID, warehouseID, stockDTO);
    }
	
}
