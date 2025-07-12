package org.example.streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacterUsingStreams {

    public static String nonRepeating(String word) {
        return Arrays.stream(word.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("-");
    }

    public static void main(String[] args) {
        System.out.println(nonRepeating("abaecabad"));
    }


}
