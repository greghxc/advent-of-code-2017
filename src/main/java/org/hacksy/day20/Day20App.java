package org.hacksy.day20;

import java.io.File;

public class Day20App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day20App.class.getClassLoader();
        File file = new File(classLoader.getResource("day20/input.txt").getFile());

        Day20Processor processor = new Day20Processor();

        System.out.println(
                String.format("Day 20 - Part 1: %s",
                        processor.partOne(file)));
        System.out.println(
                String.format("Day 20 - Part 2: %s",
                        processor.partTwo(file)));
    }
}
