package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	
    public Servlet1() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pincode=request.getParameter("pincode");

		String technology= request.getParameter("technology");

		 response.setContentType("text/html");  
	     PrintWriter out = response.getWriter();  
		
	     out.print("<a href='DisplayServlet?pin="+pincode+"&&technology="+technology+"'>visit</a>");  
	     
		
	}

	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
