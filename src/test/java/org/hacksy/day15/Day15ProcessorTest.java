package org.hacksy.day15;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day15ProcessorTest {
    Day15Processor processor;

    @Before
    public void setup() {
        processor = new Day15Processor();
    }

    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(65, 8921), is(588));
    }

    @Test
    public void partTwo() throws Exception {
        assertThat(processor.partTwo(65, 8921), is(309));
    }
}