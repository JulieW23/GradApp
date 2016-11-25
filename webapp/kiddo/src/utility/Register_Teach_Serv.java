package utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class Register_Teach_Serv extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	Connection connection;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try{
			
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/users_infoDB");
			connection = ds.getConnection();
			
			String query = "INSERT ";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			
		}catch(Exception e){}
		
	}
	
	
	
	

}
