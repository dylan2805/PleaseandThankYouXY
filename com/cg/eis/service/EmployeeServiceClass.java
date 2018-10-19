package com.cg.eis.service;

import com.capgemini.utils.Logging;
import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;

interface EmployeeService
{
	public void getDetails (int id, String name, double salary, String designation);
	public void determineScheme ();
	public void displayDetails ();
}

public class EmployeeServiceClass implements EmployeeService
{
	Employee employee;
	
	public EmployeeServiceClass (Employee employee)
	{
		this.employee = employee;
	}
	
	@Override
    public void getDetails (int id, String name, double salary, String designation)
    {
		employee.setId (id);
		employee.setName (name);
		employee.setDesignation (designation);
		
		try
        {
	        employee.setSalary (salary);
        }
        catch (EmployeeException e)
        {
	        Logging.LOG.error (e.getMessage ());
        }
    }

	@Override
    public void determineScheme ()
    {
		if (employee.getSalary () < 5000 && employee.getDesignation ().equalsIgnoreCase ("Clerk"))
		{
			employee.setInsuranceScheme ('-');
		}
		else if (employee.getSalary () > 5000 && employee.getSalary () < 20000 && employee.getDesignation ().equalsIgnoreCase ("System Associate"))
		{
			employee.setInsuranceScheme ('C');
		}
		else if (employee.getSalary () < 40000 && employee.getDesignation ().equalsIgnoreCase ("Programmer"))
		{
			employee.setInsuranceScheme ('B');
		}
		else if (employee.getSalary () >= 40000 && employee.getDesignation ().equalsIgnoreCase ("Manager"))
		{
			employee.setInsuranceScheme ('A');
		}
		else
		{
			Logging.LOG.error ("Invalid salary and designation combination");
			return;
		}

		Logging.LOG.info ("Employee " + employee.getName () + "\'s scheme is " + employee.getInsuranceScheme ());
    }

	@Override
    public void displayDetails ()
    {
	    Logging.LOG.info (employee);
    }
	
}
