package pl.coderslab.oop.firstclass;

public class BankAccount {
    private static int numberOfAccounts = 0;
    private final String accountNumber;
    private String owner;
    private double balance;

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BankAccount(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
        numberOfAccounts++;

    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero");
        } else if (amount > this.balance) {
            System.out.println("Insufficient funds in the account");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "Account [Number: " + accountNumber + ", Owner: " + owner + ", Balance: " + balance + "]";
    }
}
