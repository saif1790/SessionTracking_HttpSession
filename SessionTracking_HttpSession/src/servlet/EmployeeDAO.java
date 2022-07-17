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
		    employee = new Employee();
		    employee.setId(rs.getInt(1));
			employee.setName(rs.getString(2));
			employee.setPassword(rs.getString(3));
			
			
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
