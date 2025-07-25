package org.example.streams;

import org.example.models.Product;
import org.example.utils.ProductProducer;

import java.util.List;

public class DebuggingStreams {

    public static List<String> debug(List<Product> products){
        return products.stream()
                .peek(System.out::println)
                .filter(product -> product.price() > 4000.0)
                .map(Product::name)
                .peek(System.out::println)
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(debug(ProductProducer.products()));
    }
}
