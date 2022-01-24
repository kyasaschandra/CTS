package co.cts.dao;

import com.cts.vo.Warehouse;

public interface WarehouseDAO {
	public int warehouseValidation(Warehouse w); 
	public int warehouseInsertion(Warehouse w);
}
