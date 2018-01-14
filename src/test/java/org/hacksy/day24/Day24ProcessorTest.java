package org.hacksy.day24;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day24ProcessorTest {
    @Test
    public void partOne() throws Exception {
        Day24Processor processor = new Day24Processor();
        ClassLoader classLoader = getClass().getClassLoader();
        File file =  new File(classLoader.getResource("day24/input.txt").getFile());
        assertThat(processor.partOne(file), is(31));
    }

}