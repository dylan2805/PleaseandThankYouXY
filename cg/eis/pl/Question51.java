package com.cg.eis.pl;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;
import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeServiceClass;

public class Question51
{
	private static final String menu [] = {"Get Details", "Determine insurance scheme", "Display details"};
	
	private EmployeeServiceClass service;
	private Employee employee;
	
	public Question51 ()
	{
		employee = new Employee ();
		service = new EmployeeServiceClass (employee);
	}
	
	public void run ()
	{	
		int choice = -1;
		boolean hasDetails = false;
		
		while (choice != 0)
		{
			choice = Keyboard.menuInput ("Select service", menu);
			
			if (hasDetails || choice < 2)
			{
				switch (choice)
				{
					case 1:
						getInput ();
						hasDetails = true;
						break;
						
					case 2:
						service.determineScheme ();
						break;
						
					case 3:
						service.displayDetails ();
				}
			}
			else
			{
				Logging.LOG.error ("*** Please enter details first ***");
			}
		}
	}
	
	public void getInput ()
	{
		int id = Keyboard.readInt ("Enter id : ");
		String name = Keyboard.readString ("Enter name : ");
		double salary = Keyboard.readDouble ("Eneter salary : ");
		String designation = Keyboard.readString ("Enter designation : ");
		
		service.getDetails (id, name, salary, designation);
	}
	
	public static void main (String [] args)
	{
		new Question51 ().run ();
	}
}
