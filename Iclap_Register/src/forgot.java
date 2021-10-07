

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class forgot
 */
@WebServlet("/forgot")
public class forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("email");
		response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		SendOtp obj=new SendOtp();
		 int g=obj.send(a);
		 out.println("<html>"); 
		 out.println("<head><link rel=\'stylesheet\' type=\'text/css\' href=\'first.css\' /><link rel=\'stylesheet\' type=\'text/css\' href=\'third.css\' /><meta name='viewport' content='width=device-width,initial-scale=1'> <meta content='width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' /></head>");
		 out.println("<body>");
		String sql="update db3 set password="+g+" where email='"+a+"'";
		 
		
		 try {
			 Class.forName("com.mysql.jdbc.Driver");

			 java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", ""); 
			 java.sql.Statement st=con.createStatement();
			 int r=st.executeUpdate(sql);
             if(r>0)
            	 out.print("<h2 style=font-size:25px>we had send you a mail with your new password.!</h2>");
             else
            	 out.print("<h2>user not found.!</h2>");
		 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}

}
