package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.util.Dao;

public class AddTraining extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tid = request.getParameter("tid");
		String tna = request.getParameter("tna");
		String std = request.getParameter("std");
		String ed = request.getParameter("ed");
		String tnm = request.getParameter("tnm");
		String  bnut= request.getParameter("bnut");
		String ctid = request.getParameter("ctid");
		
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		
		System.out.println(tid+" : "+tna+" : "+std+" : "+ed+" : "+tnm+" : "+bnut+" : "+ctid);
		
		try {
			boolean rs = Dao.addTraining(tid, tna, std, ed, tnm, bnut, ctid);
			
			if(rs) {
				System.out.println("Training Added!");
				response.sendRedirect("TrainingOps");
			}else {
				System.out.println("Unable to record training!");
			}
			
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
