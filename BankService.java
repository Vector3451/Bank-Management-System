package Bank;

import java.util.List;
import java.util.ArrayList;
public class BankService {
	private List<BankAccount> customers = new ArrayList<>();
	public void addCustomer(BankAccount customer)
	{
		customers.add(customer);
		System.out.println("Account added successfuly");
	}
	public void depositCustomer(String accNo, double amount)
	{
		for(BankAccount acc : customers)
		{
			if(acc.getAccno().equals(accNo))
			{
				double newBalance = acc.getBalance() + amount;
				acc.setBalance(newBalance);
				System.out.println("Deposited " + amount + "\nNew Balance : " + newBalance);
				return;
			}
			else
			{
				System.out.println("Account not found.");
			}
		}
	}
	public void withdrawCustomer(String accNo, double amount)
	{
		for (BankAccount acc : customers) 
		{
			if (acc.getAccno().equals(accNo)) 
			{
				if (acc.getBalance() >= amount) 
				{
					double newBalance = acc.getBalance() - amount;
					acc.setBalance(newBalance);
					System.out.println("Withdrawn " + amount + "\nNew Balance: " + newBalance);
				} else {
					System.out.println("Insufficient balance.");
				}
				return;
			}
			else
			{
				System.out.println("Account not found.");
			}
		}
	}
	public void viewCustomer()
	{
		if (customers.isEmpty()) {
            System.out.println("No accounts to display.");
        } 
		else
		{
            for (BankAccount acc : customers) 
            {
                System.out.println("Account No: " + acc.getAccno());
                System.out.println("Holder Name: " + acc.getAccholder());
                System.out.println("Balance: " + acc.getBalance());
            }
        }
	}
	public void transfer(String fromAccNo, String toAccNo, double amount) 
	{
        BankAccount sender = null, receiver = null;
        for (BankAccount acc : customers) {
            if (acc.getAccno().equals(fromAccNo)) 
            {
                sender = acc;
            } else if (acc.getAccno().equals(toAccNo))
            {
                receiver = acc;
            }
        }
        if (sender == null || receiver == null) {
            System.out.println("One or both accounts not found.");
            return;
        }
        if (sender.getBalance() < amount) {
            System.out.println("Insufficient funds in sender's account.");
            return;
        }
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
        System.out.println("Transfer successful: " + amount + " from " + fromAccNo + " to " + toAccNo);
    }
}
