

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
 * Servlet implementation class plumber1
 */
@WebServlet("/plumber1")
public class plumber1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String area=request.getParameter("ar");
	   	String sql="Select *from db3 where Area='"+area+"'and Service='plumber'";
	   	PrintWriter out=response.getWriter();
	    response.setContentType("text/html");
	    out.println("<html>"); 
	    out.println("<head><link rel=\'stylesheet\' type=\'text/css\' href=\'first.css\' /><link rel=\'stylesheet\' type=\'text/css\' href=\'third.css\' /><meta name='viewport' content='width=device-width,initial-scale=1'> <meta content='width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' /></head>");
		 out.println("<body>");
		  	try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", ""); 
             java.sql.Statement st=con.createStatement();
             ResultSet rs=st.executeQuery(sql);
			 if(rs.next())
			 {
				 out.print("<section>");

				 out.print("<div class='tbl-header'>");
			 
				 out.print("<table cellpading='0' cellspacing='0' border='0'><thead>");
				 out.print("<tr><th>First Name</th>");
				 out.print("<th>Last NAme</th>"); 
				 out.print("<th>Mobile No</th>");
				 out.print("<th width='180px'>Email</th>"); 
				 out.print("<th>Area</th>");
				 out.print("</tr></thead></table></div>"); 
				 do{ 
				 String fn=rs.getString(1);
				 String ln=rs.getString(2);
				 String em=rs.getString(3);
				 String mn=rs.getString(4);
				 String ar=rs.getString(5);
				 String w=rs.getString(6);
				 out.print("<div class='table-content'>");
				 out.print("<table cellpading='0' cellspacing='0' border='0'><tbody>");
				 out.print("<tr align='center'>");
				 out.print("<td>"+fn+"</td>");
				 out.print("<td>"+ln+"</td>"); 
				 out.print("<td>"+em+"</td>");
				 out.print("<td width='180px'>"+mn+"</td>"); 
				 out.print("<td>"+ar+"</td>");
				 out.print("</tr>"); 
				 
			 }
			 while(rs.next());
			 out.print("</table>");

			 out.print("</center>");
			 }else
			 {
				 out.print("we are not currently working in your area");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	out.println("<script language='text/javascript' src='function.js'>");
		 out.println("</body>");
		 out.println("<html>"); 
	
	}

}
