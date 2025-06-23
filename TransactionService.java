package Bank;

import java.util.*;

public class TransactionService {
    private List<Transaction> transactions = new ArrayList<>();

    public void recordTransaction(String accountNumber, double amount, String type) 
    {
        transactions.add(new Transaction(accountNumber, amount, type));
    }
    public List<Transaction> getTransactionsByAccount(String accNo) 
    {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) 
        {
            if (t.getAccno().equals(accNo)) 
            {
                result.add(t);
            }
        }
        return result;
    }
    public void printTransactions(String accNo)
    {
        List<Transaction> txns = getTransactionsByAccount(accNo);
        if (txns.isEmpty()) 
        {
            System.out.println("No transactions found for account: " + accNo);
        }
        else 
        {
            for (Transaction t : txns)
            {
            	long randomNum = (long) (Math.random() * 10000000);
                System.out.println("[" + t.getTimestamp() + "] " + "\nTask Performed : " + t.getType() + "\nMoney : " + t.getAmount() + "\nID : " + randomNum + "\n----------------------");
            }
        }
    }
}
