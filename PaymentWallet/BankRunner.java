import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidInputException;
import com.cg.service.ServiceInterface;

public class BankRunner implements Runnable
{
	private ServiceInterface service;
	
	public BankRunner (ServiceInterface service)
    {
		this.service = service;
    }
	
	@Override
    public void run ()
    {
		try
        {
	        service.transferFunds ("98765432", "91234567", 400);
        }
        catch (AccountNotFoundException | InsufficientBalanceException | InvalidInputException e)
        {
	        throw new RuntimeException (e);	// wrapping exception
        }
    }
}
