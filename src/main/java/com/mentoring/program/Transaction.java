package com.mentoring.program;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionType;
    private double sum;
    private LocalDateTime date;

   public Transaction(String transactionType, double sum) {
        this.transactionType = transactionType;
        this.sum = sum;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String simpleDate = date.getDayOfMonth() + "/" + date.getMonthValue();
        return "[" + simpleDate + "] You made a " + transactionType + " of " + sum + " euros.";
    }
}
    