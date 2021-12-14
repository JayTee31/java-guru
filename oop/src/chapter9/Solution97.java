package chapter9;

import java.util.Date;

public class Solution97 {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);

        Account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);

        System.out.println(account);
    }

    public static class Account {
        private int id;
        private double balance;
        private static double annualInterestRate;
        private final Date dateCreated;

        public Account(final int id, final double balance) {
            this.id = id;
            this.balance = balance;
            annualInterestRate = 0;
            dateCreated = new Date();
        }

        Account() {
            this(0, 0);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public static double getAnnualInterestRate() {
            return annualInterestRate;
        }

        public static void setAnnualInterestRate(double annualInterestRate) {
            Account.annualInterestRate = annualInterestRate;
        }

        public String getDateCreated() {
            return dateCreated.toString();
        }

        public double getMonthlyInterestRate() {
            return annualInterestRate / 100 / 12;
        }

        public double getMonthlyInterest() {
            return balance * getMonthlyInterestRate();
        }

        public void withdraw(final double value) {
            balance -= value;
        }

        public void deposit(final double value) {
            balance += value;
        }

        @Override
        public String toString() {
            return "The Account's " +
                    "id = " + id +
                    ", balance = " + balance +
                    ", monthlyInterestRate = " + getMonthlyInterestRate() +
                    ", dateCreated = " + getDateCreated();
        }
    }
}
