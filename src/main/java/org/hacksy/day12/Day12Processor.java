package org.hacksy.day12;

import org.hacksy.util.FileUtil;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Day12Processor {
    Integer partOne(File file) {
        List<String> lines = FileUtil.fileToStringList(file);
        QuickFind qf = buildQuickFind(lines);

        Integer count = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (qf.connected(0, i)) {
                count++;
            }
        }

        return count;
    }

    Integer partTwo(File file) {
        List<String> lines = FileUtil.fileToStringList(file);
        QuickFind qf = buildQuickFind(lines);

        return qf.groups();
    }

    private QuickFind buildQuickFind(List<String> lines) {
        QuickFind qf = new QuickFind(lines.size());

        for (String line : lines) {
            List<Integer> numbers = Arrays.stream(line.split("[\\s<>\\-,]+"))
                    .map(Integer::parseInt).collect(Collectors.toList());
            for (Integer n : numbers.subList(1, numbers.size())) {
                qf.connect(n, numbers.get(0));
            }
        }

        return qf;
    }
}
