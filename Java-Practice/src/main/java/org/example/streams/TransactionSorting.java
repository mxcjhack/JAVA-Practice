package org.example.streams;

import org.example.models.Employee;
import org.example.models.Transaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Given a list of `Transaction` objects where each Transaction has:

- `String customerId`
- `double amount`

Return the top 3 customers who have spent the most. If fewer than 3 customers exist, return all sorted by amount spent.
 */
public class TransactionSorting {

    public static List<Transaction> generateTransactions() {
        List<Transaction> list = new ArrayList<>();

        list.add(new Transaction("C001", 100.0));
        list.add(new Transaction("C002", 150.0));
        list.add(new Transaction("C003", 200.0));
        list.add(new Transaction("C001", 150.0));   // same customerID as first, same amount as second
        list.add(new Transaction("C004", 100.0));   // same amount as first
        list.add(new Transaction("C005", 300.0));
        list.add(new Transaction("C003", 100.0));   // same customerID as third, same amount as first
        list.add(new Transaction("C006", 150.0));   // same amount as second
        list.add(new Transaction("C002", 300.0));   // same customerID as second, same amount as sixth
        list.add(new Transaction("C007", 200.0));   // same amount as third

        return list;
    }

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
