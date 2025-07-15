package org.example.utils;

import org.example.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionGenerator {

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
}
