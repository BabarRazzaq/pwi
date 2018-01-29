package com.pwi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pwi.dto.WarehouseDTO;
import com.pwi.service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	
	@Autowired
	private WarehouseService warehouseService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public List<WarehouseDTO> getAllWarehous() {
		return warehouseService.getAllWarehouses();
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public WarehouseDTO getWarehouse(@PathVariable("id") int warehouseID) {
		return warehouseService.getWarehous(warehouseID);
    }
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public Integer addWarehouse(@RequestBody WarehouseDTO warehouseDTO) {
		return warehouseService.saveWarehous(warehouseDTO);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateWarehouse(@PathVariable("id") int warehouseID, @RequestBody WarehouseDTO warehouseDTO) {
		warehouseService.updateWarehous(warehouseID, warehouseDTO);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteWarehouse(@PathVariable("id") int warehouseID) {
		warehouseService.deleteWarehous(warehouseID);
    }
}
