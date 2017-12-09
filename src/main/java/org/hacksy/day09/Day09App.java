package org.hacksy.day09;

import java.io.File;

public class Day09App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day09App.class.getClassLoader();
        File file = new File(classLoader.getResource("day09/input.txt").getFile());

        Day09Processor processor = new Day09Processor();
        System.out.println(
                String.format("Day 9 - Part 1: %s",
                        processor.partOne(file)));
        System.out.println(
                String.format("Day 8 - Part 2: %s",
                        processor.partTwo(file)));
    }
}
