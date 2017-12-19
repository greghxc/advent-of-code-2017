package org.hacksy.day15;

public class Day15App {
    public static void main( String[] args ) throws Exception {
        Day15Processor processor = new Day15Processor();
        System.out.println(
                String.format("Day 15 - Part 1: %s",
                        processor.partOne(699, 124)));
        System.out.println(
                String.format("Day 15 - Part 2: %s",
                        processor.partTwo(699, 124)));
    }
}
