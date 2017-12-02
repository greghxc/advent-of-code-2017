package org.hacksy.day02;

import com.google.common.collect.Lists;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Day02Processor {
    int part01(File file) throws Exception {
        return processFile(file, this::processSortedRowDayOne);
    }

    int part02(File file) throws Exception {
        return processFile(file, this::processSortedRowDayTwo);
    }

    private int processFile(File file, Function<List<Integer>, Integer> rowProcessor) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
            return stream
                    .map(line -> Arrays.stream(line.split("\t"))
                            .map(Integer::parseInt)
                            .sorted()
                            .collect(Collectors.toList()))
                    .mapToInt(rowProcessor::apply)
                    .sum();
        }
    }

    // assumes sorted list
    private int processSortedRowDayOne(List<Integer> integerList) {
        return integerList.get(integerList.size() - 1) - integerList.get(0);
    }

    // <sarcasm>totally readable</sarcasm> & doesn't benefit from the list being pre-sorted.
    private int processSortedRowDayTwo(List<Integer> integerList) {
        return integerList.stream()
                .flatMap((i) -> integerList.stream()
                        .map((i2) -> Lists.newArrayList(i, i2)))
                .filter((t) -> t.get(0) % t.get(1) == 0 && !t.get(0).equals(t.get(1)))
                .map((t) -> t.get(0) / t.get(1))
                .mapToInt(Integer::intValue)
                .sum();
    }
}
