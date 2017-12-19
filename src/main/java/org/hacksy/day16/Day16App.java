package org.hacksy.day16;

import java.io.File;

public class Day16App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day16App.class.getClassLoader();
        File file = new File(classLoader.getResource("day16/input.txt").getFile());

        Day16Processor processor = new Day16Processor();
        System.out.println(
                String.format("Day 16 - Part 1: %s",
                        processor.partOne(file, "abcdefghijklmnop")));
        System.out.println(
                String.format("Day 16 - Part 2a: %s",
                        processor.partTwo(file, "abcdefghijklmnop", 1000000000)));
    }
}
