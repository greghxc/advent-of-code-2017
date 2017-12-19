package org.hacksy.day18;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day18ProcessorPart2Test {
    @Test
    public void partTwo() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("day18/input2.txt").getFile());

        Day18ProcessorPart2 p2 = new Day18ProcessorPart2();

        assertThat(p2.partTwo(file), is(3));
    }

}