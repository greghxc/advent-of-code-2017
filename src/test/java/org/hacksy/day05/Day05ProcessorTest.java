package org.hacksy.day05;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day05ProcessorTest {
    Day05Processor processor;
    File file;
    ClassLoader classLoader = getClass().getClassLoader();

    @Before
    public void setup() {
        processor = new Day05Processor();
        file = new File(classLoader.getResource("day05/input.txt").getFile());
    }

    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(file), is(5));
    }

    @Test
    public void partTwo() throws Exception {
        assertThat(processor.partTwo(file), is(10));
    }
}