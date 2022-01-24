package co.cts.dao;

import com.cts.vo.Admin;

public interface AdminStaffDAO {
	
	public int adminValidation(Admin a); 
	public int staffValidation(Admin a); 
	public int insertion(Admin a);
}
