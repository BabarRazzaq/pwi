package com.pwi.service;

import java.util.List;

import com.pwi.dto.ProductDTO;
import com.pwi.dto.StockDTO;

public interface ProductService {

	public int saveProduct(ProductDTO product);
	
	public ProductDTO getProduct(int productID);
	
	public List<ProductDTO> getAllProducts();
	
	public void updateProduct(int productID, ProductDTO product);
	
	public void deleteProduct(int productID);
	
	public List<StockDTO> getProductAttributes(int productID);

	public List<StockDTO> getProductAttributesByWarehouse(int productID, int warehouseIdD);
}
