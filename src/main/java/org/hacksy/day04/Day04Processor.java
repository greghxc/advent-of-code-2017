package org.hacksy.day04;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

class Day04Processor {
    boolean validPasswordPartOne(String password) {
        Set<String> set = new HashSet<>();
        for (String word : password.split(" ")) {
            if (set.contains(word)) {
                return false;
            } else {
                set.add(word);
            }
        }
        return true;
    }

    boolean validPasswordPartTwo(String password) {
        Set<String> set = new HashSet<>();
        for (String word : password.split(" ")) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (set.contains(sorted)) {
                return false;
            } else {
                set.add(sorted);
            }
        }
        return true;
    }

    private int partOne(File file, Function<String, Boolean> definition) throws Exception{
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
            return stream
                    .mapToInt(line -> definition.apply(line) ? 1 : 0)
                    .sum();
        }
    }

    public int partOne(File file) throws Exception {
       return partOne(file, this::validPasswordPartOne);
    }

    public int partTwo(File file) throws Exception {
        return partOne(file, this::validPasswordPartTwo);
    }
}
