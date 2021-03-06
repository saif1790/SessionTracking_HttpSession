package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginSrv extends HttpServlet {
	Connection con;
	Statement stmt;
	String validEmail;
	String validPassword;
   Employee employee;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String email = req.getParameter("email");
		String email1 = "'" + email + "'";
		System.out.println(email1);
		String pass = req.getParameter("password");
		String enryptedPassword = EncryptPassword.getEncryptedPassword(pass);
		String pass1 = "'" + enryptedPassword + "'";
		boolean rememberMe ="true".equals(req.getParameter("checked"));
		try {

			con = DBConnection.createConnection();
			// select * from naukri where username='saif' and password="1234";
			String query = "select * from naukri where  email=" + email1 + "and password=" + pass1;
			System.out.println("query" + query);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setEmail(rs.getString(10));
				employee.setPassword(rs.getString(3));
				/*
				 * validEmail = rs.getString(3); validPassword = rs.getString(4);
				 */
				
			}

			if (email.equalsIgnoreCase(employee.email)
					&& pass.equals(DecryptPassword.getDecryptedPassword(employee.password))) {
				/*
				 * if(rememberMe) { System.out.println("remember me checked"); }
				 */
				Calendar cal = Calendar.getInstance();

				int date = cal.get(Calendar.DAY_OF_WEEK) - 1;

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				req.getRequestDispatcher("index.html").include(req, res);
				System.out.println(date);
				pw.print(dtf.format(now));
				if (date == 1)
					pw.print("<h2 align='center'>Day:Monday</h2>");
				else if (date == 2)
					pw.print("<h2 align='center'>Date:Tuesday</h2>");
				else if (date == 3)
					pw.print("<h2 align='center'>Date:Wednesday</h2>");
				else if (date == 4)
					pw.print("<h2 align='center'>Date:Thursday</h2>");
				else if (date == 5)
					pw.print("<h2 align='center'>Date:Friday</h2>");
				else if (date == 6)
					pw.print("<h2 align='center'>Date:Saturday</h2>");
				else
					pw.print("<h2 align='center'>Day:Sunday</h2>");

				// System.out.println("name"+name+"validName"+validName);
				HttpSession session = req.getSession();
				/* req.getRequestDispatcher("index.html").include(req, res); */
				session.setAttribute("email", employee.email);
				req.getRequestDispatcher("welcome.jsp").include(req, res);
				pw.println("<h3 style='text-color:red align='right'>" + employee.name.toUpperCase() + "</h3>");

				session.setMaxInactiveInterval(300);
				// session.setAttribute("timeOutTimeInSeconds", 30);
				// session.setAttribute("showTimerTimeInSeconds", 30);
				// req.getRequestDispatcher("login.html");

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

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}

}
