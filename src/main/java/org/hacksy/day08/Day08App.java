package org.hacksy.day08;

import java.io.File;

public class Day08App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day08App.class.getClassLoader();
        File file = new File(classLoader.getResource("day08/input.txt").getFile());

        Day08Processor processor = new Day08Processor();
        System.out.println(
                String.format("Day 8 - Part 1: %s",
                        processor.partOne(file)));
        System.out.println(
                String.format("Day 8 - Part 2: %s",
                        processor.partTwo(file)));
    }
}
