package org.hacksy.day10;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;

import java.util.List;

public class Day10App {
    public static void main( String[] args ) throws Exception {
        Day10Processor processor = new Day10Processor();
        List<Integer> string = ContiguousSet.create(Range.closed(0, 255), DiscreteDomain.integers()).asList();

        System.out.println(
                String.format("Day 10 - Part 1: %s",
                        processor.partOne(string, Lists.newArrayList(165,1,255,31,87,52,24,113,0,91,148,254,158,2,73,153))));
        System.out.println(
                String.format("Day 10 - Part 2: %s",
                        processor.partTwo("165,1,255,31,87,52,24,113,0,91,148,254,158,2,73,153")));
    }
}
