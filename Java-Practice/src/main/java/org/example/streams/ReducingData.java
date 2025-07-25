package org.example.streams;


import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

/*
Use `Stream.reduce()` to compute a final result from a collection of data.

Requirements:

Define a `Transaction` class with fields `id`, `amount`, and `type` (deposit/withdrawal).
Create a list of transactions.
Use `Stream.reduce()` to calculate the total balance, assuming that deposits increase the balance and withdrawals decrease it.
 */

public class ReducingData {

    public static Double reduceTransactions(List<Transaction> list){

        return list.stream()
                .map(transaction -> {
                    if(transaction.type.equalsIgnoreCase("credit")){
                        return transaction.amount;
                    } else{
                        return -transaction.amount;
                    }
                })
                .reduce(0.0, Double::sum);

    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, 1500.00, "credit"),
                new Transaction(2, 250.75, "debit"),
                new Transaction(3, 999.99, "credit"),
                new Transaction(4, 12000.00, "credit"),
                new Transaction(5, 850.50, "debit"),
                new Transaction(6, 300.00, "debit"),
                new Transaction(7, 50.00, "credit"),
                new Transaction(8, 7000.00, "credit"),
                new Transaction(9, 120.00, "debit"),
                new Transaction(10, 500.00, "credit")
        );

        System.out.println(reduceTransactions(transactions));


    }

    @AllArgsConstructor
    static class Transaction{
        int id;
        double amount;
        String type;
    }
}
