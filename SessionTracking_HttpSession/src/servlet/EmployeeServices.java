package servlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

public class EmployeeServices {

	String randomPassword;
	 EmployeeDAO dao;
	//List<Employee> employeeRecords = new ArrayList<>();
	 Employee empRecord = new Employee();
	public String  resetCustomerPassword(String email) throws SQLException {
		
		EmployeeDAO dao;
		try {
			dao = new EmployeeDAO();
			Employee emp = dao.findByEmail(email);
		     
		    randomPassword = RandomStringUtils.randomAlphanumeric(10);
		     
		    emp.setPassword(EncryptPassword.getEncryptedPassword(randomPassword));
		    dao.updateResetPassword(emp);
		  // return randomPassword;
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return randomPassword;
		
	}
	
	public Employee getEmployeeRecord(String email) 
	{   
		dao=new EmployeeDAO();
		
		try {
			empRecord = dao.findByEmail(email);
			//employeeRecords.add(empRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empRecord;  
	}
}
