package org.hacksy.day13;

import org.hacksy.util.FileUtil;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

class Day13Processor {
    Integer partOne(File file) {
        BiFunction<Integer, Integer, Integer> calc = (depth, range) -> depth * range;
        return severity(lineParser(FileUtil.fileToStringList(file)), 0, calc);
    }

    Integer partTwo(File file) {
        BiFunction<Integer, Integer, Integer> calc = (_depth, _range) -> 1;
        List<List<Integer>> parsedLines = lineParser(FileUtil.fileToStringList(file));

        Integer result = null;

        for(int i = 0; result == null; i++){
            if (severity(parsedLines, i, calc) == 0) { result = i; } else { i++; }
        }

        return result;
    }

    private Integer severity(List<List<Integer>> lines, Integer delay, BiFunction<Integer, Integer, Integer> calc) {
        return lines.stream()
                .mapToInt((items) -> {
                    Integer depth = items.get(0);
                    Integer range = items.get(1);
                    Integer div = range * 2 - 2;
                    return div <= 0 || (depth + delay) % div == 0 ? calc.apply(depth, range) : 0;
                })
                .sum();
    }

    private List<List<Integer>> lineParser(List<String> lines) {
        return lines.stream()
                .map((line) -> Arrays.stream(line.split("[\\s:]+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
