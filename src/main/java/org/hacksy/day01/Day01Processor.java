package org.hacksy.day01;

import java.util.function.BiFunction;

public class Day01Processor {
    // these lambdas describe how we calculate the index to compare the current char to in a circular string
    private BiFunction<String, Integer, Integer> partOneCompareIndexer =
            (String input, Integer i) -> (i + 1) % (input.length());
    private BiFunction<String, Integer, Integer> partTwoCompareIndexer =
            (String input, Integer i) -> (i + input.length() / 2) % input.length();

    public int partOne(String input) {
        return run(input, partOneCompareIndexer);
    }

    public int partTwo(String input) {
        return run(input, partTwoCompareIndexer);
    }

    private int run(String input, BiFunction<String, Integer, Integer> indexCalculator) {
        int acc = 0;
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(indexCalculator.apply(input, i))) {
                acc += Integer.parseInt(String.valueOf(input.charAt(i)));
            }
        }
        return acc;
    }
}
