package org.hacksy.day25;

public class Day25App {
    public static void main( String[] args ) throws Exception {
        Day25Processor processor = new Day25Processor();

        System.out.println(
                String.format("Day 25 - Part 1: %s",
                        processor.partOne(12994925)));
    }
}
