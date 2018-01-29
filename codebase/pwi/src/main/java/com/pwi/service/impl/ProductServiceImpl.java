package com.pwi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pwi.dao.ProductDAO;
import com.pwi.dto.ProductDTO;
import com.pwi.dto.StockDTO;
import com.pwi.entity.FamilyOfBrand;
import com.pwi.entity.Product;
import com.pwi.entity.ProductType;
import com.pwi.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public int saveProduct(ProductDTO productDTO) {
		Product product = this.populateProduct(productDTO);
		return productDAO.save(product);
	}
	
	@Override
	public ProductDTO getProduct(int productID) {
		return productDAO.getProductByID(productID);
	}
	
	@Override
	public List<ProductDTO> getAllProducts() {
		return productDAO.list();
	}
	
	@Override
	public void updateProduct(int productID, ProductDTO productDTO) {
		Product product = this.populateProduct(productDTO);
		productDAO.update(product);
	}
	
	@Override
	public void deleteProduct(int productID) {
		ProductDTO productDTO = productDAO.getProductByID(productID);
		productDTO.setIsDeleted(1);
		
		Product product = this.populateProduct(productDTO);
		productDAO.delete(product);
	}
	
	@Override
	public List<StockDTO> getProductAttributes(int productID) {
		return productDAO.getProductAttributes(productID);
	}

	@Override
	public List<StockDTO> getProductAttributesByWarehouse(int productID, int warehouseIdD) {
		return productDAO.getProductAttributesByWarehouse(productID, warehouseIdD);
	}
	
	private Product populateProduct(ProductDTO productDTO) {
		Product product = null;
		if(productDTO != null) {
			product = new Product();
			
			FamilyOfBrand brand = new FamilyOfBrand();
			brand.setBrandId(productDTO.getBrandId());
			
			ProductType type = new ProductType();
			type.setTypeId(productDTO.getTypeId());
			
			product.setProductId(productDTO.getProductId());
			product.setIsDeleted(productDTO.getIsDeleted());
			product.setMinimumOrderQuantity(productDTO.getMinimumOrderQuantity());
			product.setName(productDTO.getName());
			product.setQuantityPerBox(productDTO.getQuantityPerBox());
			product.setReorderPoint(productDTO.getReorderPoint());
			product.setFamilyOfBrand(brand);
			product.setProductType(type);
		}
		return product;
	}
}
