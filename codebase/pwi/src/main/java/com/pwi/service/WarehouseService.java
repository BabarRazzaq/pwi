package com.pwi.service;

import java.util.List;

import com.pwi.dto.WarehouseDTO;

public interface WarehouseService {

	public int saveWarehous(WarehouseDTO warehous);
	
	public WarehouseDTO getWarehous(int warehouseID);
	
	public List<WarehouseDTO> getAllWarehouses();
	
	public void updateWarehous(int warehouseID, WarehouseDTO warehous);
	
	public void deleteWarehous(int warehouseID);
}
