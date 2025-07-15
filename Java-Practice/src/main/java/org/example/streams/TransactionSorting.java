package org.example.streams;

import org.example.models.Employee;
import org.example.models.Transaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.example.utils.TransactionGenerator.generateTransactions;

/*
Given a list of `Transaction` objects where each Transaction has:

- `String customerId`
- `double amount`

Return the top 3 customers who have spent the most. If fewer than 3 customers exist, return all sorted by amount spent.
 */
public class TransactionSorting {



    public static void top3(List<Transaction> transactions){
        System.out.println(transactions.stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .map(Transaction::getCustomerID)
                .limit(3)
                .toList());
    }

    public static void main(String[] args) {
        top3(generateTransactions());
    }
}
