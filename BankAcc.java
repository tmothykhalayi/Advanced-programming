// Custom Exception for insufficient funds
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String msg) {
        super(msg);
    }
}

// Custom Exception for invalid PIN
class InvalidPINException extends Exception {
    InvalidPINException(String msg) {
        super(msg);
    }
}

class BankAccount {
    private double balance = 3000;
    private int pin = 1111;

    void withdraw(double amount, int enteredPin)
            throws InsufficientFundsException, InvalidPINException {

        if (enteredPin != pin)
            throw new InvalidPINException("Invalid PIN");

        if (amount <= 0)
            throw new IllegalArgumentException("Negative amount not allowed");

        if (amount > balance)
            throw new InsufficientFundsException("Insufficient funds");

        balance -= amount;
        System.out.println("Withdrawal successful. Balance: " + balance);
    }
}

public class BankAcc {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        try {
            acc.withdraw(2000, 1111);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
