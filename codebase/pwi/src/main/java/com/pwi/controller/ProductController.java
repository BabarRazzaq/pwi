package com.pwi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pwi.dto.ProductDTO;
import com.pwi.dto.StockDTO;
import com.pwi.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	public interface ProductURI {
	}
	
	private final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ProductDTO> getProducts() {
		log.info("Get All Products URL Call");
		return productService.getAllProducts();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductDTO getProduct(@PathVariable("id") int productID) {
		log.info("Get Product By ID URL Call");
		return productService.getProduct(productID);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public Integer addProduct(@RequestBody ProductDTO productDTO) {
		log.info("Add Product URL Call");
		return productService.saveProduct(productDTO);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable("id") int productID, @RequestBody ProductDTO productDTO) {
		log.info("Update Product URL Call By ID: " + productID);
		productService.updateProduct(productID, productDTO);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int productID) {
		log.info("DELETE Product URL Call By ID: " + productID);
		productService.deleteProduct(productID);
    }
	
	@RequestMapping(value = "/attributes/{id}", method = RequestMethod.GET)
    public List<StockDTO> getProductAttribtes(@PathVariable("id") int productID) {
		log.info("GET Product Attributes URL Call By ID: " + productID);
		return productService.getProductAttributes(productID);
    }

	@RequestMapping(value = "/attributes/{id}/warehouse/{warehouseId}", method = RequestMethod.GET)
    public List<StockDTO> getProductAttribtesByWarehouse(@PathVariable("id") int productID, @PathVariable("warehouseId") int warehouseID) {
		log.info("Update Product Attributes By Warehouse ID Call By WAREHOUSE_ID: " + warehouseID);
		return productService.getProductAttributesByWarehouse(productID, warehouseID);
    }
}
