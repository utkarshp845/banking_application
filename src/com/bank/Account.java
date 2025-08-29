package com.bank;

import java.util.ArrayList;

public class Account {
    private String accountId;
    private String accountHolderName;
    private double balance;
    private ArrayList<Transaction> transactions;

    // Constructor
    public Account(String accountId, String accountHolderName, double initialBalance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        addTransaction("Account created", initialBalance, "Initial deposit");
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit", amount, "Deposited to account");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawal", amount, "Withdrawn from account");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Get account details
    public void getAccountDetails() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }

    // Add transaction to history
    public void addTransaction(String type, double amount, String note) {
        transactions.add(new Transaction(type, amount, note));
    }

    // Print transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction History for " + accountHolderName + ":");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}