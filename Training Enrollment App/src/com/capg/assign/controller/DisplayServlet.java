package com.capg.assign.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capg.assign.dao.DbConnect;

public class DisplayServlet extends HttpServlet {

    public DisplayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String tName=request.getParameter("tname");
		int noOfSeats =Integer.parseInt(request.getParameter("noOfSeats")); 

		if(noOfSeats!=0)
		{
			try {
				Connection connection= DbConnect.getConnection();
				Statement st= connection.createStatement();
			
				out.print("Hi you have successfully enrolled for"+tName+" Training.");
				
				String query=" UPDATE TRAINING SET AvailableSeats = '"+--noOfSeats+"'WHERE TRAININGNAME = '"+tName+"'";
				ResultSet rs= st.executeQuery(query);

			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			out.print("Sorry Seats are not available for this training");
			RequestDispatcher rd= request.getRequestDispatcher("DatabaseServlet");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
