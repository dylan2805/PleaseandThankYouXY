import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstPage extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public FirstPage ()
	{
		super ();
	}

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		request.getSession ().getId ();
		String url = response.encodeURL ("secondPage");
		System.out.println (url);
		
		PrintWriter printWriter = response.getWriter ();
		
		printWriter.println ("<!DOCTYPE html>");
		printWriter.println ("<html>");
		printWriter.println ("<body>");
		printWriter.println ("<form method = 'POST' action = '" + url + "'>");
		printWriter.println ("First Name <input type = 'text' name = 'firstName'><br>");
		printWriter.println ("Last Name <input type = 'text' name = 'lastName'><br>");
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