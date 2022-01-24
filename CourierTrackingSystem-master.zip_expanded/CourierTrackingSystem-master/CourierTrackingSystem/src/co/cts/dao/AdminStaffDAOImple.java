package co.cts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cts.util.Db;
import com.cts.vo.Admin;

public class AdminStaffDAOImple implements AdminStaffDAO {

	int result = 0;

	

	@Override
	public int adminValidation(Admin a) {

		try {
			PreparedStatement pst = Db.getDb().prepareStatement("select * from staff where loginType='A'");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				if (a.getEmail().equals(rs.getString(4)) && a.getPassword().equals(rs.getString(7)) ) {
					if (rs.getString(12).equalsIgnoreCase("approved")) {
						result = 1;
					} else if (rs.getString(12).equalsIgnoreCase("rejected")) {
						result = 11;
					} else if (rs.getString(12).equalsIgnoreCase("pending")) {
						result = 111;
					}
//					else {
//						result = 1111;
//					}
				}

			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return result;
	}

	@Override
	public int staffValidation(Admin a) {

		try {
			PreparedStatement pst = Db.getDb().prepareStatement("select * from staff where loginType='S'");
			ResultSet res = pst.executeQuery();

			while (res.next()) {
				if (a.getEmail().equals(res.getString(4)) && a.getPassword().equals(res.getString(7)) ) {
					if (res.getString(12).equalsIgnoreCase("approved")) {
						result = 2;
					} else if (res.getString(12).equalsIgnoreCase("rejected")) {
						result = 22;
					} else if (res.getString(12).equalsIgnoreCase("pending")) {
						result = 222;
					}
//					else {
//						result = 2222;
//					}

				}

			}

		} catch (

		Exception e) {
			System.err.println(e);
		}
		return result;

	}

	public int insertion(Admin a) {

		try {
			PreparedStatement pst = Db.getDb().prepareStatement(
					"insert into staff(firstName,lastName,gender,email,contactNumber,employeeId,password,salary,designation,correpondanceAddress,loginType,approved) values('"
							+ a.getFirstName() + "','" + a.getLastName() + "','" + a.getGender() + "','" + a.getEmail()
							+ "','" + a.getContactNumber() + "','" + a.getEmployeeId() + "','" + a.getPassword() + "','" + a.getSalary() + "','"
							+ a.getDesignation() + "','" + a.getCorrepondanceAddress() + "','" + a.getLoginType()
							+ "','" + a.getStatus() + "');");
			result = pst.executeUpdate();
			// System.out.println(result);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
