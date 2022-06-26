package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet 
{
	 
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 
		res.setContentType("text/html");  
        PrintWriter out=res.getWriter();   
        HttpSession session=req.getSession(false);  
        if(session!=null){  
        String name=(String)session.getAttribute("name");  
        req.getRequestDispatcher("index.html").include(req, res);
        out.print("<br/>");
        out.print("Hello, "+name+" Welcome to Profile");  
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
