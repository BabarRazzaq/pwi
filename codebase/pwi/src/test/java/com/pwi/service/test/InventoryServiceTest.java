package com.pwi.service.test;

import static org.mockito.Matchers.isA;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.pwi.dao.InventoryDAO;
import com.pwi.dto.StockDTO;
import com.pwi.service.impl.InventoryServiceImpl;

public class InventoryServiceTest {

	@InjectMocks
	private InventoryServiceImpl inventoryService;
	
	@Mock
	private InventoryDAO inventoryDAO;
	
	private StockDTO stockDTO;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		stockDTO = new StockDTO();
		stockDTO.setAvailableQuantity(20);
		
		Mockito.doNothing().when(inventoryDAO).updateProductStock(isA(Integer.class), isA(StockDTO.class));
		Mockito.doNothing().when(inventoryDAO).updateProductStockByWarehouse(isA(Integer.class), isA(Integer.class),  isA(StockDTO.class));
	}

	@Test
	public void testUpdateProductStock() {
		inventoryService.updateProductStock(100, stockDTO);
	}

	@Test
	public void testUpdateProductStockByWarehouse() {
		inventoryService.updateProductStockByWarehouse(100, 200, stockDTO);
	}

}
