package example.jpa;

import javax.persistence.*;

public class EmployeeTest
{
	public static void main (String [] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory ("hello");	// Create factory
		EntityManager em = emf.createEntityManager ();									// Use factory to create manager
		EmployeeService service = new EmployeeService (em);								// Create entity in service
		
		City city = new City ("Mumbai");
		Country country = new Country ("India", city);
		
		em.getTransaction ().begin ();																// Begin transaction
		Employee emp = service.createEmployee ("Sagar", 60000, new Address ("Whatever", country));	// Perform transaction
		em.getTransaction ().commit ();																// Commit transaction
		System.out.println ("Persisted " + emp);

		/*emp = service.findEmployee (50948);												// Find using manager
		System.out.println ("Found " + emp);

		em.getTransaction ().begin ();													// Begin transaction
		emp = service.raiseEmployeeSalary (50948, 20000);								// Perform transaction
		em.getTransaction ().commit ();													// Commit transaction
		System.out.println ("Updated " + emp);*/
		
		em.close ();
		emf.close ();
	}
}