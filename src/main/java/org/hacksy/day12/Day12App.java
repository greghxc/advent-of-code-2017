package org.hacksy.day12;

import java.io.File;

public class Day12App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day12App.class.getClassLoader();
        File file = new File(classLoader.getResource("day12/input.txt").getFile());

        Day12Processor processor = new Day12Processor();
        System.out.println(
                String.format("Day 12 - Part 1: %s",
                        processor.partOne(file)));
        System.out.println(
                String.format("Day 12 - Part 2: %s",
                        processor.partTwo(file)));
    }
}
