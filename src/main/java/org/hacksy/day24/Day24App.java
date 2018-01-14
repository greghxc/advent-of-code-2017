package org.hacksy.day24;

import java.io.File;

public class Day24App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day24App.class.getClassLoader();
        File file = new File(classLoader.getResource("day24/input.txt").getFile());

        Day24Processor processor = new Day24Processor();

        System.out.println(
                String.format("Day 24 - Part 1: %s",
                        processor.partOne(file)));

        System.out.println(
                String.format("Day 24 - Part 2: %s",
                        processor.partTwo(file)));
    }
}
