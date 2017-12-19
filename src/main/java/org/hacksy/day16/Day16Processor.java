package org.hacksy.day16;

import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;
import lombok.Data;
import org.hacksy.util.FileUtil;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day16Processor {
    String partOne(File file, String startString) {
        List<String> start = Chars.asList(startString.toCharArray()).stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        return dance(file, start).stream()
                .reduce("", (a, b) -> a + b);
    }

    String partTwo(File file, String startString, Integer iterations) {
        Set<String> results = new HashSet<>();
        Integer repeatsAt = null;

        String lastResult = startString;
        for (int i = 0; i < iterations && repeatsAt == null; i++) {
            List<String> start = Chars.asList(lastResult.toCharArray()).stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList());
            String result = dance(file, start).stream()
                    .reduce("", (a, b) -> a + b);
            lastResult = result;
            if (!results.add(result)) {
                repeatsAt = i;
            }
        }

        if (repeatsAt != null) {
            return partTwo(file, lastResult, (iterations % repeatsAt) - 1);
        } else {
            return lastResult;
        }
    }

    String partTwoBrute(File file, String string, Integer iterations) {
        String lastResult = string;
        for (int i = 0; i < iterations; i++) {
            List<String> start = Chars.asList(lastResult.toCharArray()).stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList());
            String result = dance(file, start).stream()
                    .reduce("", (a, b) -> a + b);
            lastResult = result;
        }
        return lastResult;
    }

    @Data
    class Instruction {
        final String action;
        final List<String> parameters;

        void execute(DanceTroupe troupe) {
            switch(action) {
                case "s":
                    troupe.spin(Integer.parseInt(parameters.get(0)));
                    break;
                case "p":
                    troupe.partner(parameters.get(0), parameters.get(1));
                    break;
                case "x":
                    troupe.exchange(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)));
                    break;
                default:
                    throw new RuntimeException("Unexpected instruction: " + action);
            }
        }
    }

    private <T> List<T> dance(File file, List<T> startString) {
        String input = FileUtil.fileToStringList(file).get(0);
        DanceTroupe troupe = new DanceTroupe(startString);

        List<Instruction> instructions = Arrays.stream(input.split(","))
                .map((ins) -> {
                    String insType = ins.substring(0,1);
                    List<String> args = Lists.newArrayList(ins.substring(1).split("/"));
                    return new Instruction(insType, args);
                })
                .collect(Collectors.toList());

        for (Instruction instruction : instructions) {
            instruction.execute(troupe);
        }

        return troupe.asList();
    }
}
