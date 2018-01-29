package com.pwi.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.pwi.dto.ProductDTO;
import com.pwi.dto.StockDTO;
import com.pwi.entity.Product;

@Repository
public class ProductDAO extends AbstractDAO<Integer, Product>{
	
	public int save(Product product) {
		getSession().save(product);
	    return product.getProductId();
	}
	
	public ProductDTO getProductByID(int productID) {
		String select = "select new com.pwi.dto.ProductDTO(p.productId,p.isDeleted,p.minimumOrderQuantity,p.name,p.quantityPerBox,p.reorderPoint,p.familyOfBrand.brandName,p.productType.productType) from Product p where p.productId=:productId";
		Query query = getSession().createQuery(select);
        query.setInteger("productId", productID);

		return (ProductDTO) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ProductDTO> list() {
		String select = "select new com.pwi.dto.ProductDTO(p.productId,p.isDeleted,p.minimumOrderQuantity,p.name,p.quantityPerBox,p.reorderPoint,p.familyOfBrand.brandName,p.productType.productType) from Product p";
		Query query = getSession().createQuery(select);
        
        return query.list();
	}

	public void update(Product product) {
		getSession().saveOrUpdate(product);
	}
	
	public void delete(Product product) {
		getSession().saveOrUpdate(product);
	}

	@SuppressWarnings("unchecked")
	public List<StockDTO> getProductAttributes(int productId) {
		String select = "select new com.pwi.dto.StockDTO(ss.productWarehous.productAttribute.attributeDetail.name,sum(ss.availableQuantity),sum(ss.inStock)) from StockSummary ss where ss.productWarehous.productAttribute.product.productId=:productId group by ss.productWarehous.productAttribute.attributeDetail.name";
		Query query = getSession().createQuery(select);
        query.setInteger("productId", productId);
        return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<StockDTO> getProductAttributesByWarehouse(int productId, int warehouseId) {
		String select = "select new com.pwi.dto.StockDTO(ss.productWarehous.warehouse.name,ss.productWarehous.productAttribute.attributeDetail.name,ss.availableQuantity,ss.inStock) from StockSummary ss where ss.productWarehous.productAttribute.product.productId=:productId and ss.productWarehous.warehouse.warehouseId = :warehouseId";
		Query query = getSession().createQuery(select);
        query.setInteger("productId", productId);
        query.setInteger("warehouseId", warehouseId);
        return query.list();
	}

	
	
}
