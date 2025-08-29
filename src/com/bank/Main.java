package com.bank;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a Bank object
        Bank bank = new Bank();

        // Step 2: Create multiple accounts
        System.out.println("=== Creating Accounts ===");
        bank.createAccount("ACC001", "Utkarsh Pandey", 1000.0);
        bank.createAccount("ACC002", "Alice Johnson", 1500.0);
        bank.createAccount("ACC003", "Bob Smith", 500.0);

        // Step 3: List all accounts
        System.out.println("\n=== Listing All Accounts ===");
        bank.listAccounts();

        // Step 4: Perform a transfer
        System.out.println("\n=== Transferring $300 from ACC002 to ACC003 ===");
        bank.transfer("ACC002", "ACC003", 300.0);

        // Step 5: Display updated account details and transaction history
        System.out.println("\n=== Updated Account Details and Transaction History ===");

        Account acc002 = bank.getAccount("ACC002");
        Account acc003 = bank.getAccount("ACC003");

        if (acc002 != null) {
            System.out.println("\n--- ACC002: Alice Johnson ---");
            acc002.getAccountDetails();
            acc002.printTransactionHistory();
        }

        if (acc003 != null) {
            System.out.println("\n--- ACC003: Bob Smith ---");
            acc003.getAccountDetails();
            acc003.printTransactionHistory();
        }
    }
}