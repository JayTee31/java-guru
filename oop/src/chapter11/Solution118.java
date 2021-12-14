package chapter11;

import chapter9.Solution97;
import java.util.ArrayList;
import java.util.Date;

public class Solution118 {
    public static void main(String[] args) {
        final SpecifiedAccount acc = new SpecifiedAccount("John", 1122, 1000);
        SpecifiedAccount.setAnnualInterestRate(1.5);
        acc.deposit(30);
        acc.deposit(40);
        acc.deposit(50);
        acc.withdraw(5);
        acc.withdraw(4);
        acc.withdraw(2);

        System.out.println(acc);


    }

    public static class SpecifiedAccount extends Solution97.Account {
        private final String name;
        private final ArrayList<Transaction> transactions;

        public SpecifiedAccount(final String name, final int id, final double balance) {
            super(id, balance);
            this.name = name;
            transactions = new ArrayList<>();
        }

        @Override
        public void withdraw(final double value) {
            setBalance(getBalance() - value);
            transactions.add(new Transaction('W', value, getBalance(), "Withdraw"));
        }

        @Override
        public void deposit(final double value) {
            setBalance(getBalance() + value);
            transactions.add(new Transaction('D', value, getBalance(), "Deposit"));
        }

        @Override
        public String toString() {
            return "Name: " + name +
                    ", interest rate: " + getAnnualInterestRate() +
                    ", balance: " + getBalance() +
                    "\n Transactions: \n" + transactions;
        }
    }


    public static class Transaction {
        private char type;
        private Date date;
        private double amount;
        private double newBalance;
        private String description;

        public Transaction(final char type, final double amount, final double newBalance, final String description) {
            this.type = type;
            this.amount = amount;
            this.newBalance = newBalance;
            this.description = description;
            date = new Date();
        }

        @Override
        public String toString() {
            return "Transaction: " +
                    description +
                    ", amount: " + amount +
                    ", new balance: " + newBalance +
                    "\n";
        }
    }
}
