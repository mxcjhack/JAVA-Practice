package org.example.streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
large paragraph
top N most frequently used words
ignore case sensitivity
 */
public class WordFrequencyCounter {

    public static List<Map.Entry<String, Long>> frequencyCounter(String para, int limit){
        return Arrays.stream(para.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .toList();
    }

    public static void main(String[] args) {
        String s = "Java is great and Java is powerful and Java is popular";
        for(Map.Entry<String, Long> entry : frequencyCounter(s, 2)){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
