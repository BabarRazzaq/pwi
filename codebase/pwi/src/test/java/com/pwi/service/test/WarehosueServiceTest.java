package com.pwi.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pwi.config.PWIWebConfigurerAdapter;
import com.pwi.dao.WarehouseDAO;
import com.pwi.dto.WarehouseDTO;
import com.pwi.entity.Warehouse;
import com.pwi.service.impl.WarehouseServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {PWIWebConfigurerAdapter.class})
public class WarehosueServiceTest {

	@InjectMocks
	private WarehouseServiceImpl warehouseService;
	
	@Mock
	private WarehouseDAO warehouseDAO;
    
	WarehouseDTO warehouseDTO;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		warehouseDTO = new WarehouseDTO();
		
		warehouseDTO.setWarehouseId(1);
		warehouseDTO.setAddress("Karachi Pakistan");
		warehouseDTO.setIsDeleted(0);
		warehouseDTO.setName("PAK1");
		warehouseDTO.setCountryId(6);
		
		List<WarehouseDTO> list = new ArrayList<>();
		list.add(warehouseDTO);
		
		when(warehouseDAO.list()).thenReturn(list);
		when(warehouseDAO.getWarehousByID(isA(Integer.class))).thenReturn(warehouseDTO);
		when(warehouseDAO.save(Mockito.any(Warehouse.class))).thenReturn(1);
		when(warehouseDAO.getByKey(isA(Integer.class))).thenReturn(new Warehouse());
		Mockito.doNothing().when(warehouseDAO).update(isA(Integer.class), isA(Warehouse.class));
		Mockito.doNothing().when(warehouseDAO).delete(isA(Warehouse.class));
	}
	
	@Test
	public void testSaveWarehous() {
		int row = warehouseService.saveWarehous(warehouseDTO);
		
		assertTrue(row > 0);
	}

	@Test
	public void testGetWarehous() {
		WarehouseDTO wareouseDTO = warehouseService.getWarehous(100);
		
		assertNotNull(wareouseDTO);
	}

	@Test
	public void testGetAllWarehouses() {
		List<WarehouseDTO> list = warehouseService.getAllWarehouses();
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testUpdateWarehous() {
		warehouseService.updateWarehous(100, warehouseDTO);
	}

	@Test
	public void testDeleteWarehous() {
		warehouseService.deleteWarehous(100);
	}
}