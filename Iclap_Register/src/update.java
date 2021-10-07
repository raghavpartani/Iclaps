

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fn=request.getParameter("fn");
		 String ln=request.getParameter("ln");
		 String em=request.getParameter("em");
		 String mn=request.getParameter("mn");
		 String pa=request.getParameter("pa"); 
		 String ar=request.getParameter("ar");
		 int paa=Integer.parseInt(pa); 
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 out.println("<html>");
		 out.println("<head><link rel=\'stylesheet\' type=\'text/css\' href=\'first.css\' /><link rel=\'stylesheet\' type=\'text/css\' href=\'third.css\' /><link rel=\'stylesheet\' type=\'text/css\' href=\'second.css\' /><meta name='viewport' content='width=device-width,initial-scale=1'> <meta content='width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' /></head>");
		    
		 out.println("<body>");
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root", "");
			java.sql.PreparedStatement pst=con.prepareStatement("update db3 set FirstName=?,LastName=?,MobileNo=?,Area=?,password=? where email=?");
			pst.setString(1, fn);
			pst.setString(2, ln);
			pst.setString(3, mn);
			pst.setString(4, ar);
			pst.setLong(5, paa);
			pst.setString(6, em);
			out.print("<div ><a class='loginbox' href='c1.html'><input type='button' name=''  value='HOME'></a> </div>");
			int r=pst.executeUpdate();
			if(r>0){ 
			out.println("<h2>Updated Successfully!</h2>");

			}else{
			out.println("<h2>Data Not Found!</h2>");
			}

			 con.close();
			 } catch (ClassNotFoundException e) {
			 out.println("Driver not Found");
			 } catch (SQLException e) {
			 out.println("SQL Error : "+e);
			 }


			 out.println("</body>");
			 out.println("</html>");
			 }
			
	}

