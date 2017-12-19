package org.hacksy.day17;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day17ProcessorTest {
    Day17Processor processor;

    @Before
    public void setup() {
        processor = new Day17Processor();
    }

    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(3, 2017, 2017), is(638));
    }

    @Test
    public void partTwo() throws Exception {
        assertThat(processor.partTwo(3, 9), is(9));
    }

}