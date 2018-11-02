import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public LoginPage ()
	{
		super ();
	}

	@Override
	public void init () throws ServletException
	{
		super.init ();
		getServletContext ().setAttribute ("users", new LinkedHashMap <String, User> ());
	}
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		PrintWriter printWriter = response.getWriter ();
		printWriter.println ("<!DOCTYPE html>");
		printWriter.println ("<html>");
		printWriter.println ("<body>");
		
		String email = request.getParameter ("email");
		String password = request.getParameter ("password");
		
		if (email != null && password != null)
		{
			Map <String, User> users = (LinkedHashMap <String, User>) getServletContext ().getAttribute ("users");
			
			if (users != null)
			{
				User user = users.get (email);
			
				if (user != null)
				{
					if (user.getPassword ().equals (password)) response.sendRedirect ("lastPage");
					else printWriter.println ("<p style = 'color:red'>Invalid username / password</p>");
				}
			}
		}
		
		printWriter.println ("<form method = 'GET'>");
		printWriter.println ("Login <input type = 'text' name = 'email'><br>");
		printWriter.println ("Password <input type = 'password' name = 'password'><br>");
		printWriter.println ("<input type = 'submit'/> <a href = 'firstPage'>New User</a>");
		printWriter.println ("</form>");
		printWriter.println ("</body>");		
		printWriter.println ("</html>");
	}

	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet (request, response);
	}
}