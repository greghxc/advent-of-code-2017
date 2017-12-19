package org.hacksy.day17;

public class Day17App {
    public static void main( String[] args ) throws Exception {
        Day17Processor processor = new Day17Processor();
        System.out.println(
                String.format("Day 17 - Part 1: %s",
                        processor.partOne(303, 2017, 2017)));
        System.out.println(
                String.format("Day 17 - Part 2: %s",
                        processor.partTwo(303, 50000000)));
    }
}
