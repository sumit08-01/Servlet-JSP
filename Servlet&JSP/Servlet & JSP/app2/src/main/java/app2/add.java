package app2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class add extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int i = Integer.parseInt(request.getParameter("num1"));
	        int j = Integer.parseInt(request.getParameter("num2"));
	        int y=i+j;
	        PrintWriter out = response.getWriter();
	        out.println("<h1>The Sum Of your digits is</h1> " + y);// In the html form
	        out.println("The Sum Of your digits is" + y);// Is not in html form
	        out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
