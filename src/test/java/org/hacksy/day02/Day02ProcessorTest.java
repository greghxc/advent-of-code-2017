package org.hacksy.day02;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day02ProcessorTest {
    Day02Processor processor;

    @Before
    public void setUp() {
        processor = new Day02Processor();
    }

    @Test
    public void processTest01() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("day02/part-one.txt").getFile());
        assertThat(processor.part01(file), is(18));
    }

    @Test
    public void processTest02() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("day02/part-two.txt").getFile());
        assertThat(processor.part02(file), is(9));
    }
}