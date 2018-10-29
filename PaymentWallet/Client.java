import static com.cg.utils.Keyboard.*;

public class Client
{
	public String [] menu = {"Create Account", "Show Balance", "Deposit", "Fund Trasnfer", "Print Transactions"};
	
	public void run ()
	{
		int choice = -1;
		
		while (choice != 0)
		{
			choice = menuInput ("Payment Wallet", menu);
			
			switch (choice)
			{
				case 1:
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					break;
					
				case 5:
			}
		}
	}
	
	public static void main (String [] args)
    {
	    new Client ().run ();
    }
}