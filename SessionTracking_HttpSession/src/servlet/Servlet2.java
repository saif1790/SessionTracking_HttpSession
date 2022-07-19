package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;


public class Servlet2 extends HttpServlet
{
     public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     { 
    	 res.setContentType("text/html");
    	 PrintWriter pw=res.getWriter();
    	 String exp=req.getParameter("exp");
    	  String skil=req.getParameter("skil");
    	 HttpSession session =req.getSession(false);
    	 session.setAttribute("exp", exp);
    	 session.setAttribute("skil", skil);
    	  String sid=session.getId();
    	  req.getRequestDispatcher("registerPage3.jsp").include(req, res);
			/*
			 * pw.print("<head><title>Registration Page</title></head>");
			 * pw.print("<form action='Srv3' method='post'><br>"); //
			 * pw.print("<form action='previewSrv' method='post'><br>");
			 * pw.print("Prefered City"); pw.print("<select name='city'>");
			 * pw.print("<option value='noida'>Noida");
			 * pw.print("<option value='delhi'>Delhi");
			 * pw.print("<option value='bangalore'>Bangalore"); pw.print("</select>");
			 * pw.print("Expected Salary<input type='text' name='sal'>");
			 * pw.print("<input type='submit'  value='submit'>"); pw.print("</from>") ;
			 */
     }
     public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
    	 doGet(req, res);
     }
}
