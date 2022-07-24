package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet 
{
	Connection con;
	Statement stmt;
	EmployeeServices services;
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 services=new EmployeeServices();
		res.setContentType("text/html");  
        PrintWriter out=res.getWriter();   
        HttpSession session=req.getSession(false);  
        System.out.println(session);
        if(session!=null){  
        	System.out.println(session);
        String email=(String)session.getAttribute("email");
        Employee employeeRecord = services.getEmployeeRecord(email);
		req.setAttribute("empRec", employeeRecord);
		RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
		rd.forward(req, res); 
        }  
        else{  
            out.print("Please login first");  
            req.getRequestDispatcher("login.html").include(req, res);  
        }  
        out.close(); 
	}

	 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
