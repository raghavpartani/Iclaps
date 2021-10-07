

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String e=request.getParameter("email");
		String p=request.getParameter("password");
		response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 out.println("<html>"); 
		 out.println("<head><link rel=\'stylesheet\' type=\'text/css\' href=\'first.css\' /><link rel=\'stylesheet\' type=\'text/css\' href=\'third.css\' /><meta name='viewport' content='width=device-width,initial-scale=1'> <meta content='width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' /></head>");
		 out.println("<body>");
		 out.print("<div ><a class='loginbox' href='c1.html'><input type='button' name=''  value='HOME'></a> </div>");
		 String sql="delete from db3 where email='"+e+ "'and password="+p+"";
		 String sql1="delete from db2 where email='"+e+ "'and password="+p+"";
		 try {
			 Class.forName("com.mysql.jdbc.Driver");

			 java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");  
			 java.sql.Statement st=con.createStatement();
			 int r=st.executeUpdate(sql);
			
							  if(r>0){
							  out.print("<h2>User Deleted Successfully.!</h2>");
							  int ss=st.executeUpdate(sql1);
												 
							  
							  }else{
							  out.print("<h2>No Data Found.!</h2>"); 
			 
		 }
	}
		 catch (Exception mex)
         {
            mex.printStackTrace();
         }
}}
