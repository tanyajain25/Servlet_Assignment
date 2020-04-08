package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet {

    public DisplayServlet() {
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    
	    String pincode=(request.getParameter("pin"));
	    System.out.println(pincode);
	    String technology =request.getParameter("technology");  

	    Map <String,String> map =new HashMap<String,String>();
	    map.put("110095", "Delhi");
	    map.put("201308", "Noida");
	    
	    int flag=0;
	    for(String s: map.keySet()) {
	    	
	    if(technology.equalsIgnoreCase("Java") && pincode.equalsIgnoreCase(s))
	    {
	    	out.print("Related Jobs are- 1. Java Developer  2. Full Stack Developer");
	    	out.print("</br>");
	    	out.print("in "+map.get(pincode));
	    	flag=1;
	    	break;   	
	    }
	    else if(technology.equalsIgnoreCase("Java")&& pincode.equalsIgnoreCase(s))
	    {
	    	out.print("Related Jobs are- 1. Java Developer  2. Full Stack Java Developer");
	    	out.print("</br>");
	    	out.print("in "+map.get(pincode));
	    	flag=1;
	    	break;
	    }
	    else if(technology.equalsIgnoreCase("Python")&& pincode.equalsIgnoreCase(s))
	    {
	    	out.print("Related Jobs are- 1.Python Developer - Django Framework  2. Backend Developer - Python/django Stack");
	    	out.print("</br>");
	    	out.print("in "+map.get(pincode));
	    	flag=1;
	    	break;
	    }
	    else if(technology.equalsIgnoreCase("Python")&& pincode.equalsIgnoreCase(s))
	    {
	    	out.print("Related Jobs are- 1. Data Scientist - Python/ R/sql/machine Learning/spark/scala 2. Python Developer - Django Framework");
	    	out.print("</br>");
	    	out.print("in "+map.get(pincode));
	    	flag=1;
	    	break;
	    }
	    }
	    	if(flag==0)
	    	{
	    		out.print("Pincode and Technology doesn`t match");
	    	}
	    
	}
}
	

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}


