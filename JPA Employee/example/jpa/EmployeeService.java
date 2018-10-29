package example.jpa;

import javax.persistence.*;
import java.util.List;

public class EmployeeService
{
	protected EntityManager em;

	public EmployeeService (EntityManager em)
	{
		this.em = em;
	}

	public Employee createEmployee (String name, int salary, Address address)
	{
		Employee emp = new Employee ();
		emp.setName (name);
		emp.setSalary (salary);
		emp.setAddress (address);
		em.merge (emp);	// insert into "table"
		return emp;
	}

	public void removeEmployee (int id)
	{
		Employee emp = findEmployee (id);
		if (emp != null)
		{
			em.remove (emp);	// delete from "table"
		}
	}

	public Employee raiseEmployeeSalary (int id, int raise)
	{
		Employee emp = findEmployee (id);
		if (emp != null)
		{
			emp.setSalary (emp.getSalary () + raise);	// magic
		}
		return emp;
	}

	public List <Employee> findAllEmployees ()
	{
		TypedQuery <Employee> query = em.createQuery ("Select e from Employee e", Employee.class);	// Select statement is JPQL not SQL
		return query.getResultList ();
	}

	public Employee findEmployee (int id)
	{
		return em.find (Employee.class, id);
	}
}
