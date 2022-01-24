package co.cts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cts.util.Db;
import com.cts.vo.Warehouse;

public class WarehouseDAOImple implements WarehouseDAO {
	
	int result=0;
	@Override
	public int warehouseValidation(Warehouse w)
	{
	
		
		
		try
		{
			PreparedStatement pst=Db.getDb().prepareStatement("select * from warehouse");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				if(w.getBranchId().equals(rs.getString(1)))
				{
					result=1;					
				}
									
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		return result;

}
	
	@Override
	public int warehouseInsertion(Warehouse w) {
		
		
		try
		{
			PreparedStatement pst=Db.getDb().prepareStatement("insert into warehouse(branchid,branchname,branchlocation,contactno) values('"+w.getBranchId()+"','"+w.getBranchName()+"','"+w.getBranchLocation()+"','"+w.getContactNo()+"');");
			result=pst.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return result;
		
	}
	
	//implement warehouse retrieve
	
	
}
