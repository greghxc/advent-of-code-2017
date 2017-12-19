package org.hacksy.day18;

import java.io.File;

public class Day18App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day18App.class.getClassLoader();
        File file = new File(classLoader.getResource("day18/input.txt").getFile());

        Day18Processor processor = new Day18Processor();
        Day18ProcessorPart2 processor2 = new Day18ProcessorPart2();

        System.out.println(
                String.format("Day 18 - Part 1: %s",
                        processor.partOne(file)));
        System.out.println(
                String.format("Day 18 - Part 2: %s",
                        processor2.partTwo(file)));
    }
}
