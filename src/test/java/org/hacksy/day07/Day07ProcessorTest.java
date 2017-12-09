package org.hacksy.day07;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day07ProcessorTest {
    Day07Processor processor;

    @Before
    public void setup() {
        processor = new Day07Processor();
    }

    @Test
    public void partOne() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("day07/input.txt").getFile());
        assertThat(processor.partOne(file), is("tknk"));
    }

    @Test
    public void partTwo() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("day07/input.txt").getFile());
        assertThat(processor.partTwo(file), is(60));
    }
}