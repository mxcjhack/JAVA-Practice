package org.example.streams;

/*
Implement a system that filters and groups data based on multiple conditions using `Stream.filter()` and `Stream.collect()`.

Requirements:

Define a `Product` class with fields such as `id`, `name`, `category`, and `price`.
Create a list of products.
Filter the products to:
Only include products with a price greater than a specific value.
Only include products from certain categories.
Group the filtered products by category using `Collectors.groupingBy()`.
Aggregate the results within each category by computing the total price of all products in that category using `Collectors.summingDouble()`.
Sort the products within each category by price in descending order.
 */

import org.example.models.Product;
import org.example.utils.ProductProducer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilteringAndGrouping {

    public static Map<String, Double> sortedProducts(List<Product> products){
        return products.stream()
                .filter(product -> product.price() > 1000.0)
                .filter(product -> product.category().equalsIgnoreCase("electronics")
                        || product.category().equalsIgnoreCase("accessories"))
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.summingDouble(Product::price)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public static void main(String[] args) {
        System.out.println(sortedProducts(ProductProducer.products()));
    }
}
