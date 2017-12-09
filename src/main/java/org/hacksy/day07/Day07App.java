package org.hacksy.day07;

import java.io.File;

public class Day07App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day07App.class.getClassLoader();
        File file = new File(classLoader.getResource("day07/input.txt").getFile());

        Day07Processor processor = new Day07Processor();
        System.out.println(
                String.format("Day 7 - Part 1: %s",
                        processor.partOne(file)));
        System.out.println(
                String.format("Day 7 - Part 2: %s",
                        processor.partTwo(file)));
    }
}
