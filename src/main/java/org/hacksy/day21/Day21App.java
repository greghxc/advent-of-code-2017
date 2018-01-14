package org.hacksy.day21;

import java.io.File;

public class Day21App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day21App.class.getClassLoader();
        File file = new File(classLoader.getResource("day21/input.txt").getFile());

        Day21Processor processor = new Day21Processor();

        System.out.println(
                String.format("Day 21 - Part 1: %s",
                        processor.partOne(file, 5)));
        System.out.println(
                String.format("Day 21 - Part 1: %s",
                        processor.partOne(file, 18)));
    }
}
