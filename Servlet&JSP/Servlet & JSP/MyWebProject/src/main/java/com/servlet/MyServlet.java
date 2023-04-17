package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.util.Dao;

public class MyServlet extends HttpServlet {
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		try {
			String usertype = Dao.loginMe(username, password);
			System.out.println(usertype);
			if(usertype!=null) {
				if(usertype.equals("E")) {
					rd = request.getRequestDispatcher("employee.jsp");
				}
				else {
					rd = request.getRequestDispatcher("admin.jsp");
				}
			}else {
				rd = request.getRequestDispatcher("error.jsp");
			}
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

}
