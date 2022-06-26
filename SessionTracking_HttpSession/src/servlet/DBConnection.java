package servlet;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DBConnection 
{

	static Connection con;

	public static Connection createConnection() {

		try {

			//used because when this project moved to another machine/server then location of project may be change
			String projectPath = System.getProperty("user.dir");
			 
			String path="";
			System.out.println(projectPath);
			System.out.println("D/Study/java/SessionTracking_HttpSession");
			path=projectPath+File.separator;
			System.out.println("-----------"+path);
			//FileInputStream fis = new FileInputStream("D://Study//java//SessionTracking_HttpSession//src//db.properties");
			FileInputStream fis = new FileInputStream("D://Study//java//SessionTracking_HttpSession//src//db.properties");

			Properties prop = new Properties();
			
			prop.load(fis);

			String getDriver = prop.getProperty("driver");

			String getURL = prop.getProperty("url");

			String getUser = prop.getProperty("user");

			String getpassword = prop.getProperty("password");

			// load driver
			Class.forName(getDriver);

			// cretae connection
			String url = getURL;
			
			String user = getUser;
			
			String password = getpassword;

			con = DriverManager.getConnection(url, user, password);

			System.out.println("++++++++++");
			if (con.isClosed())
			{
				
				System.out.println("Connection is closed");
			} else {
				System.out.println("Connection established........");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
}
