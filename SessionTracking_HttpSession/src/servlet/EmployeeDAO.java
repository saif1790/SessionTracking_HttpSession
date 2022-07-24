package servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO 
{
    Connection con=null;
    Statement stmt=null;
    String resetPassword=null;
    Employee employee;
	public Employee findByEmail(String email) throws SQLException
	{
		con = DBConnection.createConnection();
		// select * from naukri where email='saif.tech1790@gmail.com';
		String email1 = "'" + email + "'";
		String query = "select * from naukri where email="+email1;
			 
		System.out.println("query" + query);
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		if (rs.next()) {
			//resetPassword = rs.getString(3);
		    int userID = rs.getInt(1);
			 String userName = rs.getString(2);
			 String exp = rs.getString(4);
			 String skill = rs.getString(5);
			 String city = rs.getString(6);
			 int salary = rs.getInt(7);
			 String address = rs.getString(8);
			 int age =   rs.getInt(9);
			 String userEmail = rs.getString(10);
			  employee = new Employee();
			 employee.setId(userID);
			 employee.setName(userName);
			 employee.setExperience(exp);
			 employee.setSkill(skill);
			 employee.setCity(city);
			 employee.setSalary(salary);
			 employee.setAddress(address);
			 employee.setAge(age);
			 employee.setEmail(userEmail);
			
			
		}
		return employee;
	}
	
	public void updateResetPassword(Employee emp)
	{
		int executeUpdate=0;
		try {
			con = DBConnection.createConnection();
			// select * from naukri where email='saif.tech1790@gmail.com';
			System.out.println("emp new random pass"+emp.getPassword());
			String randomPasswordString =emp.getPassword();
			String query = "update naukri set password="+"'"+randomPasswordString+"'"+"where id="+emp.getId();
				 
			System.out.println("query" + query);
			stmt = con.createStatement();
			  executeUpdate = stmt.executeUpdate(query);
			  if(executeUpdate==1)
			  {
				  System.out.println("updated...");
			  }
			  else {
				System.out.println("not updated.");
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}
	
}
