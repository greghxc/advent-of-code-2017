package org.hacksy.day01;

public class Day01AProcessor {
    public int run(String input) {
        if (input.length() > 0) {
            int acc = 0;
            for(int i = 0; i < input.length(); i++) {
                int compareIndex = (i + 1) % (input.length());
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
