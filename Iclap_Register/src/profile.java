

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String em=request.getParameter("email");
		String p=request.getParameter("password");
		String sql="Select *from db3 where Email='"+em+"'and password="+p;
		PrintWriter out=response.getWriter();
	    response.setContentType("text/html");
	    out.println("<html>"); 
		out.println("<head><link rel=\'stylesheet\' type=\'text/css\' href=\'first.css\' /><link rel=\'stylesheet\' type=\'text/css\' href=\'third.css\' /><link rel=\'stylesheet\' type=\'text/css\' href=\'second.css\' /><meta name='viewport' content='width=device-width,initial-scale=1'> <meta content='width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' /></head>");
	    out.println("<body class='back'>");
	    
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", ""); 
             java.sql.Statement st=con.createStatement();
             ResultSet rs=st.executeQuery(sql);
			 if(rs.next())
			 {
				 out.print("<center>");
			 
				 out.print("<table border='1' width='100%' align='center'>");
				 String fn=rs.getString(1);
				 String ln=rs.getString(2);
				 String emm=rs.getString(3);
				 String mn=rs.getString(4);
				 String ar=rs.getString(5);
				 String w=rs.getString(6);
				 String pa=rs.getString(7);
				 out.print("<form action='update'>"); 
				 out.print("<input type='hidden' name='em'value='"+mn+"'>");
				 out.print("<tr><td>Email</td><td>"+mn+"</td></tr>");
				 out.print("<tr><td>First Name</td><td><input class='in' type='text' name='fn' value='"+fn+"'></td></tr>"); 
				 out.print("<tr><td>Last Name</td><td><input class='in' type='text'  name='ln' value='"+ln+"'></td></tr>"); 
				 out.print("<tr><td>Mobile no.</td><td><input type='text' class='in' name='mn' value='"+emm+"'></td></tr>"); 
				 out.print("<tr><td>Area</td><td><input type='text' name='ar' class='in' value='"+ar+"'></td></tr>"); 
				 out.print("<tr><td>Password</td><td><input type='password' class='in' name='pa' value='"+pa+"'></td></tr>");
				 out.print("<br>");
				 out.print("<button type='submit' >Update</button>");
				 out.print("</form>"); 
		
			 out.print("</table>");

			 out.print("</center>");
			 out.print("<br><br>"); 
			 out.print("<a href='delete.html'><button  class='b'>Delete Account</button></a>");
			 }else
			 {
				 out.print("<h2>No user found.!</h2>");
			 }
			 out.print("<a href='c1.html'><button  class='b'>CANCEL</button></a>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
