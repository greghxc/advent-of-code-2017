package org.hacksy.day19;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day19ProcessorTest {
    Day19Processor processor;
    File file;

    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();
        processor = new Day19Processor();
        file =  new File(classLoader.getResource("day19/input.txt").getFile());
    }

    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(file), is("ABCDEF"));
    }

    @Test
    public void partTwo() throws Exception {
        assertThat(processor.partTwo(file), is(38));
    }

}