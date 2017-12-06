package org.hacksy.day06;

import com.google.common.collect.Lists;

public class Day06App {
    public static void main( String[] args ) throws Exception {
        Day06Processor processor = new Day06Processor();
        System.out.println(
                String.format("Day 6 - Part 1: %s",
                        processor.partOne(Lists.newArrayList(4, 10, 4, 1, 8, 4, 9, 14, 5, 1, 14, 15, 0, 15, 3, 5))));
        System.out.println(
                String.format("Day 6 - Part 2: %s",
                        processor.partTwo(Lists.newArrayList(4, 10, 4, 1, 8, 4, 9, 14, 5, 1, 14, 15, 0, 15, 3, 5))));
    }
}
