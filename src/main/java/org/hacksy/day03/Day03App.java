package org.hacksy.day03;

public class Day03App {
    public static void main( String[] args ) throws Exception {
        Day03Processor processor = new Day03Processor();
        System.out.println(String.format("Day 3 - Part 1: %s", processor.partOne(312051)));
        System.out.println(String.format("Day 3 - Part 2: %s", processor.partTwo(312051)));
    }
}
