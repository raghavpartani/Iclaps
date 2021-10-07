

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class otp1
 */
@WebServlet("/otp1")
public class otp1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String a=request.getParameter("otp");
		
		response.setContentType("text/html");
		 PrintWriter out=response.getWriter(); 
		 out.println("<html>"); 
		 out.println("<head><link rel=\'stylesheet\' type=\'text/css\' href=\'first.css\' /><link rel=\'stylesheet\' type=\'text/css\' href=\'third.css\' /><meta name='viewport' content='width=device-width,initial-scale=1'> <meta content='width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' /></head>");
		 
		 out.println("<body>");
		 out.print("<div ><a class='loginbox' href='c1.html'><input type='button' name=''  value='HOME'></a> </div>");
			
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root", ""); 
		 java.sql.Statement st=con.createStatement();
		 String u="Select *from db2 where otp="+a+"";
		 ResultSet rs=st.executeQuery(u);
		 if(rs.next()){
			 String fn=rs.getString(1);
			 String ln=rs.getString(2);
			 String mn=rs.getString(3);
			 String em=rs.getString(4);
			 String ar=rs.getString(5);
			 String sr=rs.getString(6);
		     java.sql.PreparedStatement pst=con.prepareStatement("insert into db3 values(?,?,?,?,?,?,?)");
		     
		     pst.setString(1, fn);
		     pst.setString(2, ln);
		     pst.setString(3, mn);
		     pst.setString(4, em);
		     pst.setString(5, ar);
		     pst.setString(6, sr);
		     pst.setString(7, a);
		     
		     int r=pst.executeUpdate();
		     if(r>0)
		     {
		    	 out.print("<h2 style='font-size:30px;'>Thanks for registering with ICLAPs.!</h2>");
		     }
			 
		 }
		 else
		 {
			 out.print("<h2>Wrong OTP.!</h2>");
		 }
		 }
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		

		
	}

}
