package org.hacksy.day08;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day08ProcessorTest {
    private Day08Processor processor;
    private File file;

    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();

        processor = new Day08Processor();
        file = new File(classLoader.getResource("day08/input.txt").getFile());
    }

    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(file), is(1));
    }

    @Test
    public void partTwo() throws Exception {
        assertThat(processor.partTwo(file), is(10));
    }
}