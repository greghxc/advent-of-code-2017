package org.hacksy.day23;

import java.io.File;

public class Day23App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day23App.class.getClassLoader();
        File file = new File(classLoader.getResource("day23/input.txt").getFile());

        Day23Processor processor = new Day23Processor();

        System.out.println(
                String.format("Day 22 - Part 1: %s",
                        processor.partOne(file)));
//        System.out.println(
//                String.format("Day 22 - Part 2: %s",
//                        processor.partTwo(file, new Point(12,-12), 10000000)));
    }
}
