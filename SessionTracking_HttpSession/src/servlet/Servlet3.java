package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Servlet3 extends HttpServlet
{  Connection con=null;
PreparedStatement ps=null;
     public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
    	 res.setContentType("text/html");
    	 PrintWriter pw=res.getWriter();
    	 String city=req.getParameter("city");
    	 String sal=req.getParameter("sal");
    	 int sal1=Integer.parseInt(sal);
    	 HttpSession session=req.getSession(false);
    	String srv3= session.getId();
    	 String name=(String)session.getAttribute("name");
    	 String address=(String)session.getAttribute("address");
    	 String pass=(String)session.getAttribute("password");
    	 
    	 String age=(String)session.getAttribute("age");
    	 int age1=Integer.parseInt(age);
    	 String exp=(String)session.getAttribute("exp");
    	 String skil=(String)session.getAttribute("skil");
    	 
    	 
    	/* FileInputStream fis = new FileInputStream("src/db.properties");
    	 Properties p= new Properties();
    	 p.load(fis);
    	 String s1=p.getProperty("drivarName");
    	 String s2 = p.getProperty("url");
    	 String s3=p.getProperty("username");
    	 String s4=p.getProperty("password");
    	 */
          try
          {
        	  Class.forName("oracle.jdbc.driver.OracleDriver");
        	    con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	    ps=con.prepareStatement("insert into naukri values(?,?,?,?,?,?,?,?)");
        	  ps.setString(1, name);
        	  ps.setInt(4, age1);
        	  ps.setString(3, address);
        	  ps.setString(7, city);
        	  ps.setInt(8, sal1);
        	  ps.setString(5, exp);
        	  ps.setString(6, skil);
        	  ps.setString(2, pass);
        	  HttpSession session2 = req.getSession();
        	  session2.setMaxInactiveInterval(10 * 60);
        	  int i=ps.executeUpdate();
        	  if(i==0)
        	  {
        		  pw.println("User not Registered");
        	  }
        	  else
        	  {
        		  pw.println("User registered Successfully");
        		  pw.println("<a href='home.html'>Home</a>");
        	  }
        	  
        }
          catch(Exception e)
          {
        	  e.printStackTrace();
          }
          finally{
        	  try {
				con.close();
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
          }
    	 }
     public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
    	 doGet(req, res);
     }
}