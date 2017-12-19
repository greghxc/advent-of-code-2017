package org.hacksy.day18;

import org.hacksy.day16.Day16Processor;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day18ProcessorTest {
    Day18Processor processor;
    File file;

    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();

        processor = new Day18Processor();
        file =  new File(classLoader.getResource("day18/input.txt").getFile());
    }

    @Test
    public void partOne() {
        assertThat(processor.partOne(file), is(4));
    }
}