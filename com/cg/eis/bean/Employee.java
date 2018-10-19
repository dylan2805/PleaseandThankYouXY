package com.cg.eis.bean;

import com.cg.eis.exception.EmployeeException;

public class Employee
{
	private int id;
	private String name;
	private double salary;
	private String designation;
	private char insuranceScheme;
	
	public Employee ()
	{
		this.id = 0;
		this.name = "";
		this.salary = 0;
		this.designation = "";
		this.insuranceScheme = 0;
	}
	
	public Employee (int id, String name, double salary, String designation) throws EmployeeException
    {
		if (salary < 3000) throw new EmployeeException ("Salary below 3000");
		
	    this.id = id;
	    this.name = name;
	    this.salary = salary;
	    this.designation = designation;
    }

	public String toString ()
	{
		StringBuilder sb = new StringBuilder ();
		
		sb.append ("ID : ").append (id).append ('\n')
		  .append ("Name : ").append (name).append ('\n')
		  .append ("Salary : ").append (salary).append ('\n')
		  .append ("Designation : ").append (designation).append ('\n')
		  .append ("Insurance Scheme : ").append (insuranceScheme);
		
		return sb.toString ();
	}

	public int getId ()
	{
		return id;
	}

	public void setId (int id)
	{
		this.id = id;
	}

	public String getName ()
	{
		return name;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public double getSalary ()
	{
		return salary;
	}

	public void setSalary (double salary) throws EmployeeException
	{
		if (salary < 3000) throw new EmployeeException ("Salary below 3000");
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
	
	
}