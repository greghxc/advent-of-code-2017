package org.hacksy.day05;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day05Processor {
    int partOne(File file) throws Exception {
        return processFile(file, (Integer _startValue) -> 1);
    }

    int partTwo(File file) throws Exception {
        return processFile(file, (Integer startValue) -> startValue >= 3 ? -1 : 1);
    }

    private int processFile(File file, Function<Integer, Integer> modifierCalculator) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
            List<Integer> integerList = stream.map(Integer::parseInt).collect(Collectors.toList());
            int currentIndex = 0;
            int i = 0;
            while (currentIndex >= 0 && currentIndex < integerList.size()) {
                int startValue = integerList.get(currentIndex);
                int modifier = modifierCalculator.apply(startValue);
                integerList.set(currentIndex, startValue + modifier);
                currentIndex = currentIndex + startValue;
                i++;
            }
            return i;
        }
    }
}