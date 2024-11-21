package com.examples.java.reflection;
public class Main {
    public static void main(String[] args) {
        // Create a SavingsAccount instance
        AccountSaving savingsAccount = new AccountSaving();

        // Set initial balance
        savingsAccount.setBalance(20000);
        System.out.println("Initial:");
        savingsAccount.displayBalance();

        // Apply interest
        savingsAccount.applyInterest();

        // Display updated balance
        System.out.println("After Applying Interest:");
        savingsAccount.displayBalance();
    }
}