package org.example.utils;

import org.example.models.Product;

import java.util.List;

public class ProductProducer {

    public static List<Product> products(){
        return List.of(
                new Product("P001", "Laptop", "Electronics", 59999.99),
                new Product("P002", "Smartphone", "Electronics", 24999.50),
                new Product("P003", "Running Shoes", "Footwear", 3999.00),
                new Product("P004", "Bluetooth Speaker", "Electronics", 1999.99),
                new Product("P005", "Office Chair", "Furniture", 7499.00),
                new Product("P006", "Notebook", "Stationery", 49.00),
                new Product("P007", "Pen Set", "Stationery", 149.00),
                new Product("P008", "Backpack", "Accessories", 1599.00),
                new Product("P009", "Wrist Watch", "Accessories", 4599.00),
                new Product("P010", "Table Lamp", "Furniture", 1299.00)
        );
    }
}
