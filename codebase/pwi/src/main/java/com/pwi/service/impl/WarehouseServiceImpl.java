package com.pwi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pwi.dao.WarehouseDAO;
import com.pwi.dto.WarehouseDTO;
import com.pwi.entity.Country;
import com.pwi.entity.Warehouse;
import com.pwi.service.WarehouseService;

@Service
@Transactional
public class WarehouseServiceImpl  implements WarehouseService{

	@Autowired
	private WarehouseDAO warehouseDAO;
	
	public int saveWarehous(WarehouseDTO warehouseDTO) {
		Warehouse warehouse = this.populateWarehouse(warehouseDTO);
		
		return warehouseDAO.save(warehouse);
	}
	
	@Override
	public WarehouseDTO getWarehous(int warehouseID) {
		return warehouseDAO.getWarehousByID(warehouseID);
	}
	
	@Override
	public List<WarehouseDTO> getAllWarehouses() {
		return warehouseDAO.list();
	}
	
	@Override
	public void updateWarehous(int warehouseID, WarehouseDTO warehouseDTO) {
		Warehouse warehous = this.populateWarehouse(warehouseDTO);
		
		warehouseDAO.update(warehouseID, warehous);
	}

	@Override
	public void deleteWarehous(int warehouseID) {
		Warehouse warehouse = warehouseDAO.getByKey(warehouseID);
		warehouse.setIsDeleted(1);
		warehouseDAO.delete(warehouse);
	}
	
	private Warehouse populateWarehouse(WarehouseDTO warehouseDTO) {
		Warehouse warehouse = null;
		
		if(warehouseDTO != null) {
			warehouse = new Warehouse();
			
			Country country = new Country();
			country.setCountryId(warehouseDTO.getCountryId());
			
			warehouse.setWarehouseId(warehouseDTO.getWarehouseId());
			warehouse.setAddress(warehouseDTO.getAddress());
			warehouse.setIsDeleted(warehouseDTO.getIsDeleted());
			warehouse.setName(warehouseDTO.getName());
			warehouse.setCountry(country);
		}
		
		return warehouse;
	}
}
