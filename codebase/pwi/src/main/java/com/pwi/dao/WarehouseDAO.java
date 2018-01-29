package com.pwi.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.pwi.dto.WarehouseDTO;
import com.pwi.entity.Warehouse;

@Repository
public class WarehouseDAO extends AbstractDAO<Integer, Warehouse>{

	
	public int save(Warehouse warehous) {
		getSession().save(warehous);
	    return warehous.getWarehouseId();
	}
	
	public WarehouseDTO getWarehousByID(int warehouseID) {
		String select = "select new com.pwi.dto.WarehouseDTO(w.warehouseId,w.address,w.isDeleted,w.name,w.country.countryName) from Warehouse w where w.warehouseId=:warehouseId";
		Query query = getSession().createQuery(select);
        query.setInteger("warehouseId", warehouseID);

		return (WarehouseDTO) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<WarehouseDTO> list() {
		String select = "select new com.pwi.dto.WarehouseDTO(w.warehouseId,w.address,w.isDeleted,w.name,w.country.countryName) from Warehouse w";
		Query query = getSession().createQuery(select);
		
		return query.list();
	}

	public void update(int warehouseID, Warehouse warehous) {
		getSession().saveOrUpdate(warehous);
	}
	
	public void delete(Warehouse warehous) {
		getSession().saveOrUpdate(warehous);
	}
}
