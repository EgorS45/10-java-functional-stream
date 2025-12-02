package com.example.task04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {

        try {
            String text = new String(System.in.readAllBytes(), StandardCharsets.UTF_8).toLowerCase();

            Pattern pattern = Pattern.compile("[^\\p{L}\\p{Digit}]+");

            pattern.splitAsStream(text)
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                            .thenComparing(Map.Entry::getKey))
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .forEach(System.out::println);

        } catch (IOException e) {
            // In a simple console utility just print the stack trace.
            e.printStackTrace();
        }

    }

}
