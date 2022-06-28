package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
 
public class LogoutServlet extends HttpServlet
{
	 public void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException,ServletException
	   {
		 HttpSession session = req.getSession();
		 session.invalidate();
		 PrintWriter pw = res.getWriter();
		 res.setContentType("text/html");
		 req.getRequestDispatcher("index.html").include(req, res);
		 pw.println("</br>");
		 pw.println("<hr width='100%'/>");
		 pw.println("User successfully logout");
		}
	 public void doPost(HttpServletRequest req , HttpServletResponse res)throws IOException,ServletException
	   {
		 doGet(req,res);
	   }

}
