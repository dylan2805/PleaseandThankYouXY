import java.util.HashMap;
import java.util.Map;

import com.cg.beans.Customer;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;
import com.cg.repo.Repository;
import com.cg.repo.RepositoryInterface;
import com.cg.service.Service;
import com.cg.service.ServiceInterface;

public class Main
{
	public static void main (String [] args) throws InvalidInputException, AccountNotFoundException, InterruptedException
    {
	    Map <String, Customer> map = new HashMap <String, Customer> ();
	    RepositoryInterface repository = new Repository (map);
	    ServiceInterface service = new Service (repository);
	    
	    service.createAccount ("Name ", "98765432", 500);
	    service.createAccount ("Sag ar", "91234567", 1000);
	    
	    Runnable bankRunner = new BankRunner (service);
	    
	    Thread t1 = new Thread (bankRunner);
	    Thread t2 = new Thread (bankRunner);
	    
	    t1.start ();
	    t2.start ();
	    
	    Thread.sleep (2000);
	    
	    System.out.println (service.getBalance ("98765432").getWallet ().getBalance ());
	    System.out.println (service.getBalance ("91234567").getWallet ().getBalance ());
    }
}