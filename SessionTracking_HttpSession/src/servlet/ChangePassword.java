package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePassword extends HttpServlet {

	Connection con;
	PreparedStatement ps;
	Statement stmt;
	String validName;
	String validPassword;
	int id;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String oldPassword = req.getParameter("oldPassword");
		String oldEnryptedPassword = EncryptPassword.getEncryptedPassword(oldPassword);
		String oldPassword1 = "'" + oldEnryptedPassword + "'";

		System.out.println(oldPassword1);

		String newPassword = req.getParameter("newPassword");
		String newEncrytedPassword = EncryptPassword.getEncryptedPassword(newPassword);

		System.out.println("new pass" + newEncrytedPassword);

		String newConfirmedpassword = req.getParameter("newCnfPassword");
		String newConfirmedEncrytedpassword = EncryptPassword.getEncryptedPassword(newConfirmedpassword);
		String newConfirmedEncrytedpassword1 = "'" + newConfirmedEncrytedpassword + "'";

		System.out.println("cnf pass" + newConfirmedEncrytedpassword);

		// String pass1 = "'" + enryptedPassword + "'";
		try {

			con = DBConnection.createConnection();
			// select password from naukri where password='c2FpZg==';
			String query = "select id,password from naukri where  password=" + oldPassword1;
			System.out.println("query" + query);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				id = rs.getInt(1);
				validPassword = rs.getString(2);
			}

			if (oldPassword.equals(DecryptPassword.getDecryptedPassword(validPassword))) {

				if (newEncrytedPassword.equals(newConfirmedEncrytedpassword)) {
					// change password query
					String changePasswordQuery = "update naukri set password=" + newConfirmedEncrytedpassword1
							+ "where id=" + id;
					int executeUpdate = stmt.executeUpdate(changePasswordQuery);

					System.out.println("change password query" + changePasswordQuery);
					// ps.setString(1, newConfirmedEncrytedpassword);
					pw.println("<h2 style='color: green;'>Password Updated Successfully</h2>");
					req.getRequestDispatcher("login.html").include(req, res);
				} else {
					
					pw.println("<h3><font color='red'>New password and Confirmed password is not Matched</font><h3>");
					req.getRequestDispatcher("changePassword.jsp").include(req, res);
				}

				/*
				 * // System.out.println("name"+name+"validName"+validName); HttpSession session
				 * = req.getSession(); req.getRequestDispatcher("index.html").include(req, res);
				 * session.setAttribute("name", name);
				 * req.getRequestDispatcher("welcome.jsp").include(req, res);
				 * pw.println("<h3 align='right'>" + name.toUpperCase() + "</h3>");
				 * 
				 * session.setMaxInactiveInterval(300); //
				 * session.setAttribute("timeOutTimeInSeconds", 30); //
				 * session.setAttribute("showTimerTimeInSeconds", 30); //
				 * req.getRequestDispatcher("login.html");
				 */
			} else if (oldEnryptedPassword != (validPassword)) {
				pw.println("<font color='red'>Old password is not valid</font>");
				req.getRequestDispatcher("changePassword.jsp").include(req, res);
			} else {
				pw.println("<font color='red'>User not valid</font>");
				req.getRequestDispatcher("changePassword.jsp").include(req, res);
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
