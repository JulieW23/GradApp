package utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LookUp_Teacher extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	Connection connection;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/kiddodb","root","551360");
			String schoolId = (String)req.getSession().getAttribute("schoolId") ; //Integer.getInteger((String)req.getSession().getAttribute("schoolId"));
			String email = req.getParameter("email");
			
			String query = "SELECT idteacher,email,fname,lname FROM teachers WHERE (email = ? AND schoolId = ?)";
			
			PreparedStatement st = connection.prepareStatement(query);
			
			st.setString(1, email);
			st.setString(2, schoolId);
			
			ResultSet rs = st.executeQuery();
			
			if ( rs == null ){
				req.setAttribute("error","There Is No Such an Email in Our Records. Please Try again.");
				req.getRequestDispatcher("Teacher_LookUp.jsp").forward(req, resp);	
				
			}
			
			rs.next();
			/*
			
			req.setAttribute("name",name);
			req.setAttribute("lname",lname);
			req.setAttribute("pass",pass);
			req.setAttribute("email",email);*/
			
			
			//req.getRequestDispatcher("Teacher_SignUp_Res.jsp").forward(req, resp);
			
			
		}catch(Exception e){ 
            System.out.println(e);
			req.setAttribute("error","There  Was an Error in The System.  Please Try Again and Make Sure all Provided Data is Correct.");
			req.getRequestDispatcher("Teacher_LookUp.jsp").forward(req, resp);
		}
		
	}


}
