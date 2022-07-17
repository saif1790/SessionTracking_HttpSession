package servlet;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

public class EmployeeServices {

	String randomPassword;
	 
	public EmployeeServices(HttpServletRequest req,HttpServletResponse res)
	{
		
	}
	
	public String  resetCustomerPassword(String email) throws SQLException {
		
		EmployeeDAO dao;
		try {
			dao = new EmployeeDAO();
			Employee emp = dao.findByEmail(email);
		     
		    randomPassword = RandomStringUtils.randomAlphanumeric(10);
		     
		    emp.setPassword(randomPassword);
		    dao.updateResetPassword(emp);
		  // return randomPassword;
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return randomPassword;
		
	}
}
