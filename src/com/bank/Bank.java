package com.bank;

import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts;

    // Constructor
    public Bank() {
        accounts = new HashMap<>();
    }

    // Create a new account
    public void createAccount(String accountId, String holderName, double initialBalance) {
        if (accounts.containsKey(accountId)) {
            System.out.println("Account with ID " + accountId + " already exists.");
        } else {
            Account newAccount = new Account(accountId, holderName, initialBalance);
            accounts.put(accountId, newAccount);
            System.out.println("Account created successfully for " + holderName);
        }
    }

    // Get account by ID
    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    // Transfer money between accounts
    public void transfer(String fromId, String toId, double amount) {
        Account fromAccount = getAccount(fromId);
        Account toAccount = getAccount(toId);

        if (fromAccount == null || toAccount == null) {
            System.out.println("One or both accounts not found.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Transfer amount must be positive.");
            return;
        }

        if (fromAccount.getBalance() < amount) {
            System.out.println("Insufficient funds in source account.");
            return;
        }

        // Perform transfer
        fromAccount.withdraw(amount);
        fromAccount.addTransaction("Transfer Sent", amount, "Transferred to " + toId);

        toAccount.deposit(amount);
        toAccount.addTransaction("Transfer Received", amount, "Received from " + fromId);

        System.out.println("Transferred $" + amount + " from " + fromId + " to " + toId);
    }

    // List all accounts
    public void listAccounts() {
        System.out.println("=== All Bank Accounts ===");
        for (Account account : accounts.values()) {
            account.getAccountDetails();
            System.out.println("-------------------------");
        }
    }
}