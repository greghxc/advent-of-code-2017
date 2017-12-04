package org.hacksy.day04;

import java.io.File;

public class Day04App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day04App.class.getClassLoader();
        File file = new File(classLoader.getResource("day04/input.txt").getFile());

        Day04Processor processor = new Day04Processor();
        System.out.println(String.format("Day 4 - Part 1: %s", processor.partOne(file)));
        System.out.println(String.format("Day 4 - Part 2: %s", processor.partTwo(file)));

    }
}
