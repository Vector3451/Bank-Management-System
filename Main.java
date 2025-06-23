package Bank;

import java.util.Scanner;

public class Main 
{
    public static void main(String[] arg) 
    {
        TransactionService service1 = new TransactionService();
        BankService service = new BankService();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do 
        {
            System.out.println("\n------BANK MANAGEMENT SYSTEM------");
            System.out.println("1. CREATE ACCOUNT");
            System.out.println("2. VIEW ACCOUNT");
            System.out.println("3. DEPOSIT");
            System.out.println("4. WITHDRAW");
            System.out.println("5. TRANSFER");
            System.out.println("6. VIEW TRANSACTION HISTORY");
            System.out.println("7. EXIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) 
            {
                case 1 -> 
                {
                    System.out.print("Enter Bank Name: ");
                    String bname = scanner.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accno = scanner.nextLine();
                    System.out.print("Enter ISFC Code: ");
                    String isfc = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accholder = scanner.nextLine();
                    System.out.print("Enter Current Balance: ");
                    double balance = scanner.nextDouble();

                    BankAccount customer = new BankAccount(bname, accno, isfc, accholder, balance);
                    service.addCustomer(customer);
                    service1.recordTransaction(accno, balance, "Account Created");
                }
                case 2 -> service.viewCustomer();
                case 3 -> 
                {
                    System.out.print("Enter Account Number: ");
                    String accno = scanner.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double amount = scanner.nextDouble();
                    service.depositCustomer(accno, amount);
                    service1.recordTransaction(accno, amount, "Deposit");
                }
                case 4 -> 
                {
                    System.out.print("Enter Account Number: ");
                    String accno = scanner.nextLine();
                    System.out.print("Enter Amount to Withdraw: ");
                    double amount = scanner.nextDouble();
                    service.withdrawCustomer(accno, amount);
                    service1.recordTransaction(accno, amount, "Withdraw");
                }
                case 5 -> 
                {
                    System.out.print("Enter Sender Account Number: ");
                    String fromAcc = scanner.nextLine();
                    System.out.print("Enter Receiver Account Number: ");
                    String toAcc = scanner.nextLine();
                    System.out.print("Enter Amount to Transfer: ");
                    double amount = scanner.nextDouble();
                    service.transfer(fromAcc, toAcc, amount);
                    service1.recordTransaction(fromAcc, amount, "Transfer Sent");
                    service1.recordTransaction(toAcc, amount, "Transfer Received");
                }
                case 6 -> 
                {
                    System.out.print("Enter Account Number to View Transactions: ");
                    String accno = scanner.nextLine();
                    service1.printTransactions(accno);
                }
                case 7 -> 
                {
                	System.out.println("Exiting...");
                	break;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        } 
        while (choice != 7);
        scanner.close();
    }
}
