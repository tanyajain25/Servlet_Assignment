package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	
    public Servlet1() 
    {     
    }
    static Map <String,String> map= new HashMap<String,String>();
    
    static
    {
    	map.put("tanya","111");
    	map.put("sam","222");
    	map.put("ram", "333");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
		
	    Cookie c[]= request.getCookies();
	    String cookieValue = null;
	    
	    if(c!=null)
	    {
	    	for (Cookie cookie : c) 
	    	{
	    		String cookieUserName = cookie.getName();
	    		if(cookieUserName.equals("name"))
	    		{
	    			cookieValue=cookie.getValue();
	    			break;
	    		}
			}
	    	
	    }
		
		out.print("<html>");
	    out.print("<body>");
	    
	    out.print("<form action='Servlet1' method='post'>");
	    
	    if(cookieValue==null)
	    {
	    	out.print("Username<input type='text' name='name'></br></br>");
	    }
	    else
	    {
	    	out.print("Username <input type='text' name='name' value='" + cookieValue + "'><br/>");
	    }
	    out.print("Password<input type='password' name='pass'></br></br>");
	    out.print("<input type='checkbox' name='response' value='marked'/>remember me</br></br>");
	    
	    out.print("<input type='submit' name='submit' value='Submit'>");
	    out.print("</form>");
	    out.print("</body>");
	    out.print("</html>");
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
		
		String userName= request.getParameter("name");
		String password= request.getParameter("pass");
		String checkBoxValue= request.getParameter("response");
		
		Servlet1 servletObj = new Servlet1();
		boolean isValid = servletObj.isValidate(userName,password);
		
		if(isValid==true)
		{
//			out.print("validated..");
			if(checkBoxValue.equals("marked"))
			{
				Cookie c=new Cookie("name",userName); 
				c.setMaxAge(1000 * 60 * 60 * 24);
				response.addCookie(c);
				
				
				request.setAttribute("username", userName);
				request.getRequestDispatcher("Servlet2").forward(request, response);
			}
			
		}
		else
			response.sendRedirect("Servlet1");
	

	}
	
	public boolean isValidate(String userName, String password)
	{
		String pass=map.get(userName);
		
		if(password.equals(pass))
			return true;
		
		else if(password==null)
			return false;
		
		else
			return false;
			
		
	}

	
}
