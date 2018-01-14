package org.hacksy.day21;

import com.google.common.collect.Lists;
import com.google.common.math.IntMath;
import com.google.common.primitives.Chars;
import org.hacksy.util.FileUtil;

import java.io.File;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day21Processor {
    Integer partOne(File file, Integer iterations) {
        Transformer transformer = loadTransformer(file);
        List<String> grids = Lists.newArrayList(".#./..#/###");

        for(int i = 0; i < iterations; i++) {
            List<String> newGrids = Lists.newArrayList();
            for(String grid : grids) {
                newGrids.addAll(gridBreaker(grid));
            }
            newGrids = newGrids.stream()
                    .map(transformer::transform)
                    .collect(Collectors.toList());

            grids = Lists.newArrayList(strigify(newGrids));
        }

        return grids.stream()
                .mapToInt(string -> Chars.asList(string.toCharArray()).stream()
                            .filter(c -> c == "#".charAt(0))
                            .collect(Collectors.toList())
                            .size()
                ).sum();
    }

    Transformer loadTransformer(File file) {
        Transformer transformer = new Transformer();
        for(String rule : FileUtil.fileToStringList(file)) {
            String[] parts = rule.split(" => ");
            transformer.addRule(parts[0], parts[1]);
        }
        return transformer;
    }

    List<String> gridBreaker(String input) {
        input = input.replace("/","");
        Integer l = input.length();

        // make sure it's a perfect square
        Integer sqrt = IntMath.sqrt(l, RoundingMode.DOWN);
        if (l % sqrt != 0) { throw new RuntimeException("Invalid square"); }

        // make sure it's divisible by 2 or 3
        Integer divisor;
        if (l % 2 == 0) {
            divisor = 2;
        } else if (l % 3 == 0) {
            divisor = 3;
        } else {
            throw new RuntimeException("Invalid size");
        }

        List<String> output = Lists.newArrayList();

        for (int i = 0; (i + 1) * divisor <= sqrt; i++) {
            for (int j = 0; (j + 1) * divisor <= sqrt; j++) {
                StringBuilder sb = new StringBuilder();
                for (int ia = i * divisor; ia < ( i + 1) * divisor; ia++) {
                    for (int ja = j * divisor; ja < (j + 1) * divisor; ja++) {
                        sb.append(input.charAt(ia * sqrt + ja));
                    }
                }
                output.add(sb.toString());
            }
        }

        return output;
    }

    String strigify(List<String> grid) {
        // make sure it's a perfect square
        Integer sqrt = IntMath.sqrt(grid.size(), RoundingMode.DOWN);
        Integer eleSqrt = IntMath.sqrt(grid.get(0).length(), RoundingMode.DOWN);
        if (grid.size() % sqrt != 0) { throw new RuntimeException("Invalid square"); }

        List<List<StringBuilder>> unCompressedGrid = new ArrayList<>();
        for(int i = 0; i < sqrt; i++) {
            List<StringBuilder> unCompressedRow = new ArrayList<>();
            for(int j = 0; j < eleSqrt; j++) {
                unCompressedRow.add(new StringBuilder());
            }
            unCompressedGrid.add(unCompressedRow);
        }

        for(int i = 0; i < grid.size(); i++) {
            Integer row = i / sqrt;
            String body = grid.get(i);
            for (int j = 0; j < body.length(); j++) {
                Integer subRow = j / eleSqrt;
                unCompressedGrid
                        .get(row)
                        .get(subRow)
                        .append(body.charAt(j));
            }
        }

       return unCompressedGrid.stream()
                .map(row -> row.stream()
                        .map(StringBuilder::toString)
                        .collect(Collectors.joining()))
               .collect(Collectors.joining());
    }
}
