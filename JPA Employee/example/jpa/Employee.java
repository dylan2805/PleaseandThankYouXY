package example.jpa;

import javax.persistence.*;

@Entity	// Create table employee
public class Employee
{
	@Id	// Determines primary key (in this case id)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int salary;
	
	@OneToOne (cascade = CascadeType.ALL)	// relation between address and employee
	private Address address;

	public Employee ()
	{
		super ();
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

	public int getSalary ()
	{
		return salary;
	}

	public void setSalary (int salary)
	{
		this.salary = salary;
	}

	public Address getAddress ()
	{
		return address;
	}

	public void setAddress (Address address)
	{
		this.address = address;
	}

	@Override
	public String toString ()
	{
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
	}
}
