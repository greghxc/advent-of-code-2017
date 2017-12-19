package org.hacksy.day19;

import java.io.File;

public class Day19App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day19App.class.getClassLoader();
        File file = new File(classLoader.getResource("day19/input.txt").getFile());

        Day19Processor processor = new Day19Processor();

        System.out.println(
                String.format("Day 19 - Part 1: %s",
                        processor.partOne(file)));

        System.out.println(
                String.format("Day 19 - Part 2: %s",
                        processor.partTwo(file)));
    }
}
