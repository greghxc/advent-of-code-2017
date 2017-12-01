package org.hacksy.day01;

public class Day01BProcessor {
    public int run(String input) {
        if (input.length() > 0) {
            int acc = 0;
            for(int i = 0; i < input.length(); i++) {
                int compareIndex = (i + input.length() / 2) % input.length();
                if (input.charAt(i) == input.charAt(compareIndex)) {
                    acc += Integer.parseInt(String.valueOf(input.charAt(i)));
                }
            }
            return acc;
        } else {
            return 0;
        }
    }
}
