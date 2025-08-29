package com.bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private String timestamp;
    private String note;


    //Constructor
    public Transaction(String type, double amount, String note) {
        this.type = type;
        this.amount = amount;
        this.note = note;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    //Getters
    public String getType() {
        return type;
    }

    
    public double getAmount() {
            return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getNote() {
        return note;
    }

    // Display transaction
    public void printTransaction() {
        System.out.println(timestamp + " | " + type + " | $" + amount + " | " + note);
    }

}
