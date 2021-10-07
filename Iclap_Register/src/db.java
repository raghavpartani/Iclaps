

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class db
 */
@WebServlet("/db")
public class db extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("fn");
		String b=request.getParameter("ln");
		String c=request.getParameter("mn");
		String d=request.getParameter("em");
		String e=request.getParameter("ar");
		String f=request.getParameter("service");
		
		
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter(); 
		 out.println("<html>"); 
		 out.println("<head><title>My first Servlet</title></head>");
		 out.println("<body>");
		 SendOtp obj=new SendOtp();
		 int g=obj.send(d);
		 
		 
		 
		 try {
			 Class.forName("com.mysql.jdbc.Driver");

			 java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", ""); 

		 PreparedStatement pst=con.prepareStatement("insert into db2 values(?,?,?,?,?,?,?)");
				 pst.setString(1, a);
				 pst.setString(2, b);
				 pst.setString(3, c);
				 pst.setString(4, d);
				 pst.setString(5, e);
				 pst.setString(6, f);
				 pst.setInt(7,g);
				 int r=pst.executeUpdate();
				 if(r>0){
				 response.sendRedirect("Otp.html");
				 }else{
				 out.println("Registration Fail");
				 }

				  con.close();
				  } catch (ClassNotFoundException ex) {
				  out.println("Driver not Found");
				  } catch (SQLException ex) {
				  out.println("SQL Error : "+ex);
				  }


				  out.println("</body>");
				  out.println("</html>");
				  }
				 
		 }


