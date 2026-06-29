package pl.coderslab.oop.firstclass;

public class Main01 {

    public static void main(String[] args) {

        BankAccount bankAccount1 = new BankAccount("10 2074 6388 9455", "Donald Trump");
        BankAccount bankAccount2 = new BankAccount("10 2074 6388 9444", "Ronald Reagan");
        bankAccount1.deposit(100);
        System.out.println(bankAccount1.getBalance());
        System.out.println(bankAccount1);
        bankAccount1.withdraw(20);
        bankAccount1.withdraw(100);
        System.out.println(bankAccount1);
        bankAccount2.deposit(400);
        System.out.println(bankAccount2.getBalance());
        System.out.println(bankAccount2);
        System.out.println(BankAccount.getNumberOfAccounts());
    }
}
