package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginSrv extends HttpServlet {
	Connection con = null;
	Statement stmt = null;
	String validName;
	String validPassword;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String name = req.getParameter("name");
		String name1 = "'" + name + "'";
		System.out.println(name1);
		String pass = req.getParameter("pass");
		String pass1 = "'" + pass + "'";
		System.out.println(pass1);

		try {

			Connection con = DBConnection.createConnection();
			// select * from naukri where username='saif' and password="1234";

			System.out.println("nahi mila");
			stmt=con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select name,password from naukri where  name="
							+ name1 + "and password=" + pass1);
			System.out.println("adding manually");

			if (rs.next()) {
				validName = rs.getString(1);
				validPassword = rs.getString(2);
				// System.out.println(validName);
			}

			if (name.equals(validName) && pass.equals(validPassword)) {
				// Calendar cal =Calendar.getInstance();
				/*
				 * int date = cal. System.out.println(date);
				 * 
				 * if(date==1) pw.print("<h2 align='center'>Day:Monday</h2>");
				 * else if(date==2)
				 * pw.print("<h2 align='center'>Date:Tuesday</h2>"); else
				 * if(date==3)
				 * pw.print("<h2 align='center'>Date:Wednesday</h2>"); else
				 * if(date==4)
				 * pw.print("<h2 align='center'>Date:Thursday</h2>"); else
				 * if(date==5) pw.print("<h2 align='center'>Date:Friday</h2>");
				 * else if(date==6)
				 * pw.print("<h2 align='center'>Date:Saturday</h2>"); else
				 * pw.print("<h2 align='right'>Day:Sunday</h2>");
				 */
				// System.out.println("name"+name+"validName"+validName);
				HttpSession session = req.getSession();
				req.getRequestDispatcher("index.html").include(req, res);
				session.setAttribute("name", name);
				req.getRequestDispatcher("welcome.jsp").include(req, res);
				pw.println("<h3 align='right'>" + name + "</h3>");

			} else {
				pw.println("<font color='red'>User not valid</font>");
				req.getRequestDispatcher("login.html").include(req, res);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		doGet(req, res);
	}

}
