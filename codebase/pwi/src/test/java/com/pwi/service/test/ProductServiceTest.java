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
import com.pwi.dao.ProductDAO;
import com.pwi.dto.ProductDTO;
import com.pwi.dto.StockDTO;
import com.pwi.entity.Product;
import com.pwi.service.impl.ProductServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {PWIWebConfigurerAdapter.class})
public class ProductServiceTest {

	@InjectMocks
	private ProductServiceImpl productService;
	
	@Mock
	private ProductDAO productDAO;
	
	private ProductDTO productDTO;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		productDTO = new ProductDTO();
		
		productDTO.setProductId(100);
		productDTO.setIsDeleted(0);
		productDTO.setMinimumOrderQuantity(200);
		productDTO.setName("Cloths");
		productDTO.setQuantityPerBox(1);
		productDTO.setReorderPoint(20);
		productDTO.setBrandId(6);
		productDTO.setTypeId(6);
		
		List<ProductDTO> list = new ArrayList<>();
		list.add(productDTO);
		
		StockDTO stockDTO = new StockDTO();
		stockDTO.setAttribute("Size");
		stockDTO.setAvailableQuantity(200);
		stockDTO.setInStock(150);
		stockDTO.setWarehouse(null);
		
		List<StockDTO> listStockByProduct = new ArrayList<>();
		listStockByProduct.add(stockDTO);
		
		stockDTO.setWarehouse("PAK1");
		
		List<StockDTO> listStockByProductWarehouse = new ArrayList<>();
		listStockByProductWarehouse.add(stockDTO);
		
		when(productDAO.list()).thenReturn(list);
		when(productDAO.getByKey(isA(Integer.class))).thenReturn(new Product());
		when(productDAO.save(isA(Product.class))).thenReturn(1);
		when(productDAO.getProductByID(isA(Integer.class))).thenReturn(productDTO);
		Mockito.doNothing().when(productDAO).update(isA(Product.class));
		Mockito.doNothing().when(productDAO).delete(isA(Product.class));
		when(productDAO.getProductAttributes(isA(Integer.class))).thenReturn(listStockByProduct);
		when(productDAO.getProductAttributesByWarehouse(isA(Integer.class), isA(Integer.class))).thenReturn(listStockByProductWarehouse);
	}
	
	@Test
	public void testSaveProduct() {
		int row = productService.saveProduct(productDTO);
		
		assertTrue(row > 0);
	}

	@Test
	public void testGetProduct() {
		ProductDTO productDTO = productService.getProduct(100);
		
		assertNotNull(productDTO);
	}

	@Test
	public void testGetAllProducts() {
		List<ProductDTO> list = productService.getAllProducts();
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testUpdateProduct() {
		productService.updateProduct(100, productDTO);
	}

	@Test
	public void testDeleteProduct() {
		productService.deleteProduct(100);
	}

	@Test
	public void testGetProductAttributes() {
		List<StockDTO> list = productService.getProductAttributes(100);

		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testGetProductAttributesByWarehouse() {
		List<StockDTO> list = productService.getProductAttributesByWarehouse(100, 200);

		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

}
