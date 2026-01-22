package com.mentoring.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static double currentBalance = 0.0;
    static List<Transaction> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        if (!checkPin(scanner)) {
            System.out.println("Too many failed attempts. Account locked.");
            scanner.close();
            return; 
        }

        boolean running = true;
        while (running) {
            // Display menu(done)
            // Read user choice(done)
            // Perform actions based on user choice(done..the bonus tasks left!)
            System.out.println("==== BANK MENU ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Print Transaction History.");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                deposit(scanner);
            } else if (choice == 2) {
                withdraw(scanner);
            } else if (choice == 3) {
                balance();
            } else if (choice == 4) {
                System.out.println("--- HISTORY ---");
                for (Transaction t : transactionHistory) {
                    System.out.println(t);
                }
                if (transactionHistory.isEmpty()) System.out.println("No history found.");
            } else if (choice == 5) {
                System.out.println("Goodbye! Have a nice day!!");
                running = false;
            } else {
                System.out.println("Invalid option. Choose from the bank menu!");
            }
        }
        scanner.close();
    }

    public static boolean checkPin(Scanner scanner) {
        int pin = 1234;
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            int entered = scanner.nextInt();
            if (entered == pin) return true;
            attempts++;
            System.out.println("Wrong! Attempts left: " + (3 - attempts));
        }
        return false;
    }

    public static void deposit(Scanner scanner) {
            System.out.print("What amount would you like to deposit?  ");
            double amount = scanner.nextDouble();
            if (amount > 0) {
                currentBalance = currentBalance + amount;
                transactionHistory.add(new Transaction("Deposit", amount));
                System.out.println("You successfully deposited: " + amount);
            }
            else {
                System.out.println("Invalid amount.");
            }
        }
    
    public static void withdraw(Scanner scanner) {
            System.out.print("What amount would you like to withdraw? ");
            double amount = scanner.nextDouble();
            if(amount <= 0) {
                System.out.println("Invalid amount.The amount must be positive.");
            }
            else if (amount > currentBalance) {
                System.out.println("Invalid amount. Balance isn't enough.");
            }else {
                currentBalance = currentBalance - amount;
                transactionHistory.add(new Transaction("Withdrawal", amount));
                System.out.println("You successfully withdrew: " + amount);
            } 
        }

    public static void balance() {
        int euros = (int) currentBalance;
        int cents = (int) Math.round((currentBalance - euros) * 100);
        System.out.println("Your current balance is " + euros + " euros and " + cents + " cents.");
    }
}
