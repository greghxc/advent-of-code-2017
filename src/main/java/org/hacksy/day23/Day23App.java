package org.hacksy.day23;

import java.io.File;

public class Day23App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day23App.class.getClassLoader();
        File file = new File(classLoader.getResource("day23/input.txt").getFile());

        RefactoredProgram program = new RefactoredProgram();

        Day23Processor processor = new Day23Processor();

        System.out.println(
                String.format("Day 23 - Part 1: %s",
                        processor.partOne(file)));
        System.out.println(
                String.format("Day 23 - Part 2: %s",
                        program.partTwo()));
    }
}
