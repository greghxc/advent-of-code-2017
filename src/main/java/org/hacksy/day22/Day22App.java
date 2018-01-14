package org.hacksy.day22;

import java.io.File;

public class Day22App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day22App.class.getClassLoader();
        File file = new File(classLoader.getResource("day22/input.txt").getFile());

        Day22Processor processor = new Day22Processor();

        System.out.println(
                String.format("Day 22 - Part 1: %s",
                        processor.partOne(file, new Point(12,-12), 10000)));
        System.out.println(
                String.format("Day 22 - Part 2: %s",
                        processor.partTwo(file, new Point(12,-12), 10000000)));
    }
}
