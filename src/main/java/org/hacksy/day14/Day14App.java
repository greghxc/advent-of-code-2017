package org.hacksy.day14;

public class Day14App {
    public static void main( String[] args ) throws Exception {
        Day14Processor processor = new Day14Processor();

        System.out.println(
                String.format("Day 14 - Part 1: %s",
                        processor.partOne("hwlqcszp")));
        System.out.println(
                String.format("Day 14 - Part 2: %s",
                        processor.partTwo("hwlqcszp")));
    }
}
