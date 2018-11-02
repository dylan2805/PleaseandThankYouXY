import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ThirdPage extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ThirdPage ()
	{
		super ();
	}

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String url = response.encodeURL ("lastPage");
		
		PrintWriter printWriter = response.getWriter ();
		
		HttpSession session = request.getSession (false);
		session.setAttribute ("city", request.getParameter ("city"));
		session.setAttribute ("country", request.getParameter ("country"));
		
		printWriter.println ("<!DOCTYPE html>");
		printWriter.println ("<html>");
		printWriter.println ("<body>");
		printWriter.println ("First Name " + session.getAttribute ("firstName") + "<br>");
		printWriter.println ("Last Name " + session.getAttribute ("lastName") + "<br>");
		printWriter.println ("City " + session.getAttribute ("city") + "<br>");
		printWriter.println ("Country " + session.getAttribute ("country") + "<br>");
		printWriter.println ("<form method = 'POST' action = '" + url + "'>");
		printWriter.println ("Email <input type = 'text' name = 'email'><br>");
		printWriter.println ("Password <input type = 'password' name = 'password'><br>");
		printWriter.println ("<input type = 'submit'/>");
		printWriter.println ("</form>");
		printWriter.println ("</body>");		
		printWriter.println ("</html>");
	}

	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet (request, response);
	}

}
