import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LastPage extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public LastPage ()
	{
		super ();
	}

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Map <String, User> users = (LinkedHashMap <String, User>) getServletContext ().getAttribute ("users");
		
		if (users != null)
		{
			String email = request.getParameter ("email");
			String password = request.getParameter ("password");
			User user = users.get (email);
			
			if (user == null)
			{
				HttpSession session = request.getSession (false);
				user = new User (session.getAttribute ("firstName"), session.getAttribute ("lastName"),
				                 session.getAttribute ("city"), session.getAttribute ("country"),
				                 email, password);
				
				users.put (email, user);
			}

			PrintWriter printWriter = response.getWriter ();
			
			printWriter.println ("<!DOCTYPE html>");
			printWriter.println ("<html>");
			printWriter.println ("<body>");
			printWriter.println ("First Name " + user.getFirstName () + "<br>");
			printWriter.println ("Last Name " + user.getLastName () + "<br>");
			printWriter.println ("City " + user.getCity () + "<br>");
			printWriter.println ("Country " + user.getCountry () + "<br>");
			printWriter.println ("Email " + user.getEmail () + "<br>");
			printWriter.println ("<form method = 'POST' action = 'loginPage'>");
			printWriter.println ("<input type = 'submit' name = 'submit' value = 'confirm'/>");
			printWriter.println ("</form>");
			printWriter.println ("</body>");		
			printWriter.println ("</html>");
		}
	}

	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet (request, response);
	}

}
