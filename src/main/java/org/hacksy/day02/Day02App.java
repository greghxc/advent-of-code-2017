package org.hacksy.day02;

import java.io.File;

public class Day02App {
    public static void main( String[] args ) throws Exception {
        ClassLoader classLoader = Day02App.class.getClassLoader();
        File file = new File(classLoader.getResource("day02/input.txt").getFile());

        Day02Processor processor = new Day02Processor();
        System.out.println(String.format("Day 2 - Part 1: %s", processor.part01(file)));
        System.out.println(String.format("Day 2 - Part 2: %s", processor.part02(file)));
    }
}
