package com.capg.assign.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capg.assign.dao.DbConnect;

public class DatabaseServlet extends HttpServlet {

    public DatabaseServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		 try
	        {
			 	out.print("<html>");
			 	out.print("<body>");
			 	out.print("<table>");
			 	
			 	out.print("<tr>");
			 	out.print("<td> Training Id </td>");
		 	
			 	out.print("<td> Training Name </td>");
			 	out.print("<td> AvailableSeats </td>");
			 	out.print("</tr>");
			 	
			 	Connection connection= DbConnect.getConnection();
			 	Statement st= connection.createStatement();
			    ResultSet rs=st.executeQuery("Select * from Training");                                       
			    
	            while(rs.next())
	            {
	            out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td><a href='DisplayServlet?tname="+rs.getString(2)+"&&noOfSeats="+rs.getInt(3)+"'>Enroll</a></td></tr>");
	            }
	            
	             out.print("</table>");
			 	 out.print("</body>");
			 	 out.print("</html>");
			 	 out.close();
			 
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
