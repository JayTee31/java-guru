package chapter10;

import chapter9.Solution97;

import java.util.Scanner;

public class Solution107 {
    public static void main(String[] args) {
        final int NUMBER_OF_ACCOUNTS = 10;
        final Solution97.Account[] accounts = new Solution97.Account[NUMBER_OF_ACCOUNTS];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < NUMBER_OF_ACCOUNTS; i++) {
            accounts[i] = new Solution97.Account(i, 100);
        }

        while (true) {
            System.out.print("Enter an id: ");

            final int id = sc.nextInt();

            if (id < 0 || id >= NUMBER_OF_ACCOUNTS) {
                System.out.println("Wrong id.");
                continue;
            }

            while (true) {
                printMainMenu();

                final int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.println("The balance is: " + accounts[id].getBalance());
                } else if (choice == 2) {
                    System.out.print("Enter an amount to withdraw: ");

                    accounts[id].withdraw(sc.nextDouble());
                } else if (choice == 3) {
                    System.out.print("Enter an amount to deposit: ");

                    accounts[id].deposit(sc.nextDouble());
                } else if (choice == 4) {
                    break;
                }
            }
        }
    }

    public static void printMainMenu() {
        System.out.print("\nMain Menu\n1: check balance\n2: withdraw\n3: deposit\n4: exit\nEnter a choice: ");
    }


}
