package org.hacksy.day11;

import java.io.File;

public class Day11App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day11App.class.getClassLoader();
        File file = new File(classLoader.getResource("day11/input.txt").getFile());

        Day11Processor processor = new Day11Processor();

        System.out.println(
                String.format("Day 11 - Part 1: %s",
                        processor.partOne(file)));
        System.out.println(
                String.format("Day 11 - Part 2: %s",
                        processor.partTwo(file)));
    }
}
