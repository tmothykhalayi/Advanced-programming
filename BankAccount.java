import java.util.Scanner;
public class BankAccount {
    private String AccountNumber ;
    private String AccountHolderName ;
    private double balance ;
    public BankAccount(String AccountNumber, String AccountHolderName, double initialBalance) {
         this.AccountNumber = AccountNumber;
        this.AccountHolderName = AccountHolderName;
        this.balance = initialBalance;
    }
    
   //deposit method
public void deposit (double amount ){
    if (amount > 0){
        balance += amount ;
        System.out.println("Deposited: " + amount);
    } else {
        System.out.println("Deposit amount cannot be zero and below.");

    }

}
//withdraw method
public void withdraw (double amount ){
    if (amount <= 0) {
        System.out.println("Invalid withdraw amount.");
    } else if (amount <= balance) {
        balance -= amount ;
        System.out.println("Withdrawn: " + amount);
    } else {
        System.out.println("No enough balance in the account.");
    }
}
//method to check balance
public double getBalance (){
    System.out.println("Current Balance: " + balance);
    return balance ;
}

//print account details
public void displayAccountInfo() {
        System.out.println("----- Account Info -----");
        System.out.println("Account Holder: " + AccountHolderName);
        System.out.println("Account Number: " + AccountNumber);
        System.out.println( );
        System.out.println("Balance       : $" + balance);
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //create a bank account object
        System.out.println("Enter account holder name:");
        String name = sc.nextLine();
        System.out.println("Enter account number:");
        String accNo = sc.nextLine();

        BankAccount Account = new BankAccount(name, accNo, 0);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Bank Operations ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. check Balance");
            System.out.println("4. Display Account running balance");
            System.out.println("5. Out");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    Account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = sc.nextDouble();
                    Account.withdraw(withdrawAmount);
                    break;
                case 3:
                    Account.getBalance();
                    break;
                case 4:
                    Account.displayAccountInfo();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close(); 
    }
}