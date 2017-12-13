package org.hacksy.day13;

import java.io.File;

public class Day13App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day13App.class.getClassLoader();
        File file = new File(classLoader.getResource("day13/input.txt").getFile());

        Day13Processor processor = new Day13Processor();
        System.out.println(
                String.format("Day 13 - Part 1: %s",
                        processor.partOne(file)));
        System.out.println(
                String.format("Day 13 - Part 2: %s",
                        processor.partTwo(file)));
    }
}
