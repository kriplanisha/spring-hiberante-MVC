package testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class testdb_servlet
 */
@WebServlet("/testdb_servlet")
public class testdb_servlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String user="root";
		String pwd="komal";
		String jdbcurl="jdbc:mysql://127.0.0.1:3306/customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		try {
			PrintWriter out=response.getWriter();
			out.println("connecting to database:" + jdbcurl);
			Class.forName(driver);
			Connection con=DriverManager.getConnection(jdbcurl,user,pwd);
			out.println("success");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
