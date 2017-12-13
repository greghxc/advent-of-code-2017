package org.hacksy.day13;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day13ProcessorTest {
    Day13Processor processor;
    File file;

    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource("day13/input.txt").getFile());
        processor = new Day13Processor();
    }
    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(file), is(24));
    }

    @Test
    public void partTwo() throws Exception {
        assertThat(processor.partTwo(file), is(10));
    }

}