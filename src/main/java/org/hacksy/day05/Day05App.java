package org.hacksy.day05;

import java.io.File;

public class Day05App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day05App.class.getClassLoader();
        File file = new File(classLoader.getResource("day05/input.txt").getFile());

        Day05Processor processor = new Day05Processor();
        System.out.println(String.format("Day 5 - Part 1: %s", processor.partOne(file)));
        System.out.println(String.format("Day 5 - Part 2: %s", processor.partTwo(file)));

    }
}
