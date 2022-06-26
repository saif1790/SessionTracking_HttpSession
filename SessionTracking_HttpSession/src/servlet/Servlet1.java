package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Servlet1 extends HttpServlet
{
     public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
    	 res.setContentType("text/html");
    	 PrintWriter pw=res.getWriter();
    	 String name=req.getParameter("name");
    	 String address=req.getParameter("address");
    	 String pass=req.getParameter("password");
    	  String age=req.getParameter("age");
    	  HttpSession session= req.getSession();
    	    session.setAttribute("name", name);
    	    session.setAttribute("address", address);
    	    session.setAttribute("password", pass);
    	    session.setAttribute("age", age);
    	    System.out.println(pass);
    	 String sid=session.getId();
          pw.print("<form action='Srv2' method='post'><br>");
          pw.print("Experience:<br/><input type='text' name='exp'><br>");
          pw.print("Key Skil:<br/>");
          pw.print("<select name='skil'>");
    	 pw.print("<option value='java'>JAVA");
         pw.print("<option value='.net'>.NET");
         pw.print("<option value='php'>PHP");
         pw.print("</select><br/>");
         pw.print("<input type='submit'  value='submit'>");
         pw.print("</from>");
    	 }
     public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
    	 doGet(req, res);
     }
}
