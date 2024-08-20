package projectBloodKart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/contact")
public class Contact extends HttpServlet {
	
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			PrintWriter pw = res.getWriter();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shinchan");

			String s1 = req.getParameter("name");
			String s2 = req.getParameter("mail");
			String s3 = req.getParameter("phn");
			String s4 = req.getParameter("sub");
			String s5 = req.getParameter("msg");


			PreparedStatement ps = con.prepareStatement("INSERT INTO CONTACT VALUES(?,?,?,?,?)");

			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			ps.setString(4, s4);
			ps.setString(5, s5);
			
			int k = ps.executeUpdate();
			if (k == 0)
				pw.println("Invalid");
			else
				pw.println("<h1>Inserted Successfully.</h1>"
						+ "<a href=\"index.html\"><h3>Index</h3></a>");

       }
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
