import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondPage extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public SecondPage ()
	{
		super ();
	}

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String url = response.encodeURL ("thirdPage");
		
		PrintWriter printWriter = response.getWriter ();
		
		HttpSession session = request.getSession ();
		session.setAttribute ("firstName", request.getParameter ("firstName"));
		session.setAttribute ("lastName", request.getParameter ("lastName"));
		
		printWriter.println ("<!DOCTYPE html>");
		printWriter.println ("<html>");
		printWriter.println ("<body>");
		printWriter.println ("First Name " + session.getAttribute ("firstName") + "<br>");
		printWriter.println ("Last Name " + session.getAttribute ("lastName") + "<br>");
		printWriter.println ("<form method = 'POST' action = '" + url + "'>");
		printWriter.println ("City <input type = 'text' name = 'city'><br>");
		printWriter.println ("Country <input type = 'text' name = 'country'><br>");
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
