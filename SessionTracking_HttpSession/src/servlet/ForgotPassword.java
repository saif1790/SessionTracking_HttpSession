package servlet;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotPassword extends HttpServlet {

	private String host;
	private String port;
	private String email;
	private String name;
	private String pass;

	String message = "";

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		email = context.getInitParameter("email");
		name = context.getInitParameter("name");
		pass = context.getInitParameter("pass");
	}

	public ForgotPassword() {
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String email = req.getParameter("email");
		out.print(email);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/MIME");
		String recipient = req.getParameter("email");
		String subject = "Your Password has been reset";
		try {
			EmployeeServices customerServices = new EmployeeServices();
			String newPassword = customerServices.resetCustomerPassword(recipient);
			// addColor(newPassword, Color.RED);
			String addColor = addColor(newPassword, Color.RED);
			String content = "Hi, this is your new password: " + addColor;
		
			content += "\nNote: for security reason, " + "you must change your password after logging in.";

			message = "Your password has been reset.Please check your e-mail.\n" + recipient + " " + content;

			EmailUtility.sendEmail(host, port, email, name, pass, recipient, subject, message);

		} catch (Exception ex) {
			ex.printStackTrace();
			message = "There were an error: " + ex.getMessage();
		} finally {
			req.setAttribute("message", message);
			req.getRequestDispatcher("message.jsp").forward(req, res);
		}
	}

	public static String addColor(String msg, Color color) {
		String hexColor = String.format("#%06X", (0xFFFFFF & color.getRGB()));
		String colorMsg = "<FONT COLOR=\"#" + hexColor + "\">" + msg + "</FONT>";
		return colorMsg;
	}
}
