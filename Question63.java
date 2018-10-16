package com.capgemini.solutions;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;
import com.cg.eis.exception.EmployeeException;

class Employee
{
	private int id;
	private double salary;
	private String designation;
	private char insuranceScheme;
	
	public Employee (int id, double salary, String designation, char insuranceScheme) throws EmployeeException
    {
		if (salary < 3000) throw new EmployeeException ("Salary below 3000");
		
	    this.id = id;
	    this.salary = salary;
	    this.designation = designation;
	    this.insuranceScheme = insuranceScheme;
    }

	public int getId ()
	{
		return id;
	}

	public void setId (int id)
	{
		this.id = id;
	}

	public double getSalary ()
	{
		return salary;
	}

	public void setSalary (double salary)
	{
		this.salary = salary;
	}

	public String getDesignation ()
	{
		return designation;
	}

	public void setDesignation (String designation)
	{
		this.designation = designation;
	}

	public char getInsuranceScheme ()
	{
		return insuranceScheme;
	}

	public void setInsuranceScheme (char insuranceScheme)
	{
		this.insuranceScheme = insuranceScheme;
	}

	@Override
    public String toString ()
    {
	    return "Employee id=" + id + ", salary=" + salary + ", designation=" + designation +
    		   ", insuranceScheme=" + insuranceScheme;
    }
}

public class Question63
{
	public static void main (String [] args)
	{
		int id = Keyboard.readInt ("Enter id : ");
		double salary = Keyboard.readDouble ("Enter salary : ");
		String designation = Keyboard.readString ("Enter designation : ");
		char insuranceScheme = Keyboard.readChar ("Enter insurance scheme : ");
		
		try
        {
	        Employee employee = new Employee (id, salary, designation, insuranceScheme);
        }
        catch (EmployeeException e)
        {
	        Logging.LOG.error (e.getMessage ());
        }
	}
}
