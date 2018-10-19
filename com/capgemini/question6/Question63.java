package com.capgemini.question6;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;
import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;

public class Question63
{
	public static void main (String [] args)
	{
		int id = Keyboard.readInt ("Enter id : ");
		String name = Keyboard.readString ("Enter String : ");
		double salary = Keyboard.readDouble ("Enter salary : ");
		String designation = Keyboard.readString ("Enter designation : ");
		
		try
        {
	        Employee employee = new Employee (id, name, salary, designation);
	        Logging.LOG.info (employee);
        }
        catch (EmployeeException e)
        {
	        Logging.LOG.error (e.getMessage ());
        }
	}
}