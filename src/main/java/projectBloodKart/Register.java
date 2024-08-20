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

@WebServlet("/register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shinchan");
			PrintWriter pw=resp.getWriter();
			PreparedStatement ps = con.prepareStatement("insert into register values (?,?,?,?,?)");
			String s1 = req.getParameter("name");
			String s2 = req.getParameter("mob");
			String s3 = req.getParameter("mail");
			String s4 = req.getParameter("pwd");
			String s5 = req.getParameter("cfm");
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			ps.setString(4, s4);
			ps.setString(5, s5);
			int k = 0;
			if(s4.equals(s5)) {
				k = ps.executeUpdate();
				if (k == 0)
					pw.println("Invalid");
				else
					pw.println("<!doctype html>\r\n"
							+ "<html class=\"no-js\" lang=\"zxx\">\r\n"
							+ "    <head>\r\n"
							+ "        <!-- Meta Tags -->\r\n"
							+ "		<meta charset=\"utf-8\">\r\n"
							+ "		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
							+ "		<meta name=\"keywords\" content=\"Site keywords here\">\r\n"
							+ "		<meta name=\"description\" content=\"\">\r\n"
							+ "		<meta name='copyright' content=''>\r\n"
							+ "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n"
							+ "		\r\n"
							+ "		<!-- Title -->\r\n"
							+ "        <title>Registration Successful</title>\r\n"
							+ "		\r\n"
							+ "		<!-- Favicon -->\r\n"
							+ "        <link rel=\"icon\" href=\"img/logo.png\">\r\n"
							+ "		\r\n"
							+ "		<!-- Google Fonts -->\r\n"
							+ "		<link href=\"https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap\" rel=\"stylesheet\">\r\n"
							+ "\r\n"
							+ "		<!-- Bootstrap CSS -->\r\n"
							+ "		<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n"
							+ "		<!-- Nice Select CSS -->\r\n"
							+ "		<link rel=\"stylesheet\" href=\"css/nice-select.css\">\r\n"
							+ "		<!-- Font Awesome CSS -->\r\n"
							+ "        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n"
							+ "		<!-- icofont CSS -->\r\n"
							+ "        <link rel=\"stylesheet\" href=\"css/icofont.css\">\r\n"
							+ "		<!-- Slicknav -->\r\n"
							+ "		<link rel=\"stylesheet\" href=\"css/slicknav.min.css\">\r\n"
							+ "		<!-- Owl Carousel CSS -->\r\n"
							+ "        <link rel=\"stylesheet\" href=\"css/owl-carousel.css\">\r\n"
							+ "		<!-- Datepicker CSS -->\r\n"
							+ "		<link rel=\"stylesheet\" href=\"css/datepicker.css\">\r\n"
							+ "		<!-- Animate CSS -->\r\n"
							+ "        <link rel=\"stylesheet\" href=\"css/animate.min.css\">\r\n"
							+ "		<!-- Magnific Popup CSS -->\r\n"
							+ "        <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\r\n"
							+ "		\r\n"
							+ "		<!-- Medipro CSS -->\r\n"
							+ "        <link rel=\"stylesheet\" href=\"css/normalize.css\">\r\n"
							+ "        <link rel=\"stylesheet\" href=\"style.css\">\r\n"
							+ "        <link rel=\"stylesheet\" href=\"css/responsive.css\">\r\n"
							+ "		\r\n"
							+ "    </head>\r\n"
							+ "    <body>\r\n"
							+ "	\r\n"
							+ "		<!-- Breadcrumbs -->\r\n"
							+ "		<div class=\"breadcrumbs overlay\">\r\n"
							+ "			<div class=\"container\">\r\n"
							+ "				<div class=\"bread-inner\">\r\n"
							+ "					<div class=\"row\">\r\n"
							+ "						<div class=\"col-12\">\r\n"
							+ "							<h2>Registration Successfully</h2>\r\n"
							+ "							<ul class=\"bread-list\">\r\n"
							+ "								<li><a href=\"index.html\">Home</a></li>\r\n"
							+ "								<li><i class=\"icofont-simple-right\"></i></li>\r\n"
							+ "								<li class=\"active\">Registered</li>\r\n"
							+ "							</ul>\r\n"
							+ "						</div>\r\n"
							+ "					</div>\r\n"
							+ "				</div>\r\n"
							+ "			</div>\r\n"
							+ "		</div>\r\n"
							+ "		<!-- End Breadcrumbs -->\r\n"
							+ "        <div class=\"con\">\r\n"
							+ "            <h2 class=\"reg\">Registered Successfully<h2>\r\n"
							+ "                <a href=\"Login.html\">Back to Login</a>\r\n"
							+ "                </div>\r\n"
							+ "		\r\n"
							+ "				<!-- Footer Area -->\r\n"
							+ "                <footer id=\"footer\" class=\"footer \">\r\n"
							+ "                    <!-- Footer Top -->\r\n"
							+ "                    <div class=\"footer-top\">\r\n"
							+ "                        <div class=\"container\">\r\n"
							+ "                            <div class=\"row\">\r\n"
							+ "                                <div class=\"col-lg-3 col-md-6 col-12\">\r\n"
							+ "                                    <div class=\"single-footer\">\r\n"
							+ "                                        <h2>About Us</h2>\r\n"
							+ "                                        <p style=\"width: 800px;\">Welcome to BloodKart, your comprehensive solution for life-saving healthcare services including blood emergencies, hospital bed availability (BedKart), and oxygen gas supplies. We are dedicated to taking the guesswork out of critical healthcare decisions, ensuring you and your family receive timely, high-quality care. Our mission is to empower you to make informed healthcare decisions based on reliable information. We strive to make healthcare simpler and more transparent, ensuring you have access to the resources you need during critical times.</p>\r\n"
							+ "                                        <!-- Social -->\r\n"
							+ "                                        <ul class=\"social\">\r\n"
							+ "                                            <li><a href=\"https://www.facebook.com/\"><img src=\"img/facebook.png\" alt=\"\"></a></li>\r\n"
							+ "                                            <li><a href=\"https://www.instagram.com/\"><img src=\"img/instagram.png\" alt=\"\"></a></li>\r\n"
							+ "                                            <li><a href=\"https://wa.me/qr/BOWL6K6Q7JT6G1\"><img src=\"img/whatsapp.png\" alt=\"\"></a></li>\r\n"
							+ "                                            <li><a href=\"https://www.linkedin.com/\"><img src=\"img/linkedin.png\" alt=\"\"></a></li>\r\n"
							+ "                                            <li><a href=\"https://www.youtube.com/\"><img src=\"img/youtube.png\" alt=\"\"></a></li>\r\n"
							+ "                                        </ul>\r\n"
							+ "                                        <!-- End Social -->\r\n"
							+ "                                    </div>\r\n"
							+ "                                </div>\r\n"
							+ "                                <div class=\"col-lg-3 col-md-6 col-12\">\r\n"
							+ "                                </div>\r\n"
							+ "                            </div>\r\n"
							+ "                        </div>\r\n"
							+ "                    </div>\r\n"
							+ "                    <!--/ End Footer Top -->\r\n"
							+ "                    <!-- Copyright -->\r\n"
							+ "                    <div class=\"copyright\">\r\n"
							+ "                        <div class=\"container\">\r\n"
							+ "                            <div class=\"row\">\r\n"
							+ "                                <div class=\"col-lg-12 col-md-12 col-12\">\r\n"
							+ "                                    <div class=\"copyright-content\">\r\n"
							+ "                                        <p>© Copyright 2018  |  All Rights Reserved by <a href=\"https://www.wpthemesgrid.com\" target=\"_blank\">bloodkart.com</a> </p>\r\n"
							+ "                                    </div>\r\n"
							+ "                                </div>\r\n"
							+ "                            </div>\r\n"
							+ "                        </div>\r\n"
							+ "                    </div>\r\n"
							+ "                    <!--/ End Copyright -->\r\n"
							+ "                </footer>\r\n"
							+ "		\r\n"
							+ "		<!-- jquery Min JS -->\r\n"
							+ "        <script src=\"js/jquery.min.js\"></script>\r\n"
							+ "		<!-- jquery Migrate JS -->\r\n"
							+ "		<script src=\"js/jquery-migrate-3.0.0.js\"></script>\r\n"
							+ "		<!-- jquery Ui JS -->\r\n"
							+ "		<script src=\"js/jquery-ui.min.js\"></script>\r\n"
							+ "		<!-- Easing JS -->\r\n"
							+ "        <script src=\"js/easing.js\"></script>\r\n"
							+ "		<!-- Color JS -->\r\n"
							+ "		<script src=\"js/colors.js\"></script>\r\n"
							+ "		<!-- Popper JS -->\r\n"
							+ "		<script src=\"js/popper.min.js\"></script>\r\n"
							+ "		<!-- Bootstrap Datepicker JS -->\r\n"
							+ "		<script src=\"js/bootstrap-datepicker.js\"></script>\r\n"
							+ "		<!-- Jquery Nav JS -->\r\n"
							+ "        <script src=\"js/jquery.nav.js\"></script>\r\n"
							+ "		<!-- Slicknav JS -->\r\n"
							+ "		<script src=\"js/slicknav.min.js\"></script>\r\n"
							+ "		<!-- ScrollUp JS -->\r\n"
							+ "        <script src=\"js/jquery.scrollUp.min.js\"></script>\r\n"
							+ "		<!-- Niceselect JS -->\r\n"
							+ "		<script src=\"js/niceselect.js\"></script>\r\n"
							+ "		<!-- Tilt Jquery JS -->\r\n"
							+ "		<script src=\"js/tilt.jquery.min.js\"></script>\r\n"
							+ "		<!-- Owl Carousel JS -->\r\n"
							+ "        <script src=\"js/owl-carousel.js\"></script>\r\n"
							+ "		<!-- counterup JS -->\r\n"
							+ "		<script src=\"js/jquery.counterup.min.js\"></script>\r\n"
							+ "		<!-- Steller JS -->\r\n"
							+ "		<script src=\"js/steller.js\"></script>\r\n"
							+ "		<!-- Wow JS -->\r\n"
							+ "		<script src=\"js/wow.min.js\"></script>\r\n"
							+ "		<!-- Magnific Popup JS -->\r\n"
							+ "		<script src=\"js/jquery.magnific-popup.min.js\"></script>\r\n"
							+ "		<!-- Counter Up CDN JS -->\r\n"
							+ "		<script src=\"http://cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js\"></script>\r\n"
							+ "		<!-- Google Map API Key JS -->\r\n"
							+ "		<script src=\"https://maps.google.com/maps/api/js?key=AIzaSyDGqTyqoPIvYxhn_Sa7ZrK5bENUWhpCo0w\"></script>\r\n"
							+ "		<!-- Gmaps JS -->\r\n"
							+ "		<script src=\"js/gmaps.min.js\"></script>\r\n"
							+ "		<!-- Map Active JS -->\r\n"
							+ "		<script src=\"js/map-active.js\"></script>\r\n"
							+ "		<!-- Bootstrap JS -->\r\n"
							+ "		<script src=\"js/bootstrap.min.js\"></script>\r\n"
							+ "		<!-- Main JS -->\r\n"
							+ "		<script src=\"js/main.js\"></script>\r\n"
							+ "    </body>\r\n"
							+ "</html>");
				}
			else pw.println("Error : Password should Match\ncheck the password and try again...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
