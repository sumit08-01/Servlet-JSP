package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.Dao;

public class TrainingOps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String at = request.getParameter("addtraining");
		String dt = request.getParameter("deletetraining");
		System.out.println(at+" : "+dt);
		
		RequestDispatcher rd = null;
		
		try {
			ArrayList<ArrayList<Object>> list = Dao.getTrainingList();
			request.setAttribute("list", list);
			if(dt==null) {
				rd = request.getRequestDispatcher("addtraining.jsp");
			}
			else {
				rd = request.getRequestDispatcher("deletetraining.jsp");
			}
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
