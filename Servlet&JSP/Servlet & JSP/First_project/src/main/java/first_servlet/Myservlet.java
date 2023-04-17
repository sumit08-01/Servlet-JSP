package first_servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("PhoneNumber");
		String pass = req.getParameter("Password");
		
		if(email.equalsIgnoreCase("sumitgond9999@gmail.com") && pass.equalsIgnoreCase("admin")) {
			RequestDispatcher rd = req.getRequestDispatcher("welcome");
			rd.forward(req, res);
		}
		else {
			out.print("Enter correct Email and password");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, res);
		}
		
		
		
		
	}

}
