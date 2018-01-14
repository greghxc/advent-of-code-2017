package org.hacksy.day21;

import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;

import java.util.*;
import java.util.stream.Collectors;

public class Transformer {
    Map<String, String> rules = new HashMap<>();

    void addRule(String input, String output) {
        rules.put(input.replace("/", ""), output.replace("/", ""));
    }

    String transform(String input) {
        List<String> rotations = getAllRotations(input);
        for (String rotation : rotations) {
            if (rules.containsKey(rotation)) return rules.get(rotation);
        }
        throw new RuntimeException("Rule not found.");
    }

    List<String> getAllRotations(String input) {
        Set<String> rotations = new HashSet<>();
        for(int i = 0; i < 4; i++) {
            rotations.add(input);
            rotations.add(flipH(input));
            rotations.add(flipZ(input));
            input = rotate(input);
        }
        return Lists.newArrayList(rotations);
    }

    String rotate(String input) {
        Integer size = (int) Math.sqrt(input.length());
        char[] rotatedChars = new char[input.length()];
        List<Character> inputList = Chars.asList(input.toCharArray());

        for (int i = 0; i < inputList.size(); i++) {
            Integer row = i / size;
            Integer pos = i % size;

            Integer newRow = size - pos - 1;
            Integer newPos = row;

            rotatedChars[newRow * size + newPos] = inputList.get(i);
        }
        return Chars.join("", rotatedChars);
    }

    String flipH(String input) {
        return listIt(input).stream()
                .map(this::reverseString)
                .collect(Collectors.joining());
    }

    String flipZ(String input) {
        List<String> grid = listIt(input);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid.size(); j++) {
                sb.append(grid.get(j).charAt(i));
            }
        }
        return sb.toString();
    }

    String reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        List<Character> chars = Lists.reverse(Chars.asList(input.toCharArray()));
        for(Character c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    List<String> listIt(String string) {
        List<String> result;
        switch(string.length()) {
            case 4:
                result = Lists.newArrayList(
                    string.substring(0,2),
                    string.substring(2)
                );
                break;
            case 9:
                result = Lists.newArrayList(
                    string.substring(0,3),
                    string.substring(3,6),
                    string.substring(6)
                );
                break;
            default:
                throw new RuntimeException("Invalid length");
        }
        return result;
    }
}
