package org.hacksy.day03;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day03ProcessorTest {
    private Day03Processor processor;

    @Before
    public void setup(){
        processor = new Day03Processor();
    }

    @Test
    public void stepsPartOne01() throws Exception {
        assertThat(processor.stepsPartOne(1), is(0));
    }

    @Test
    public void stepsPartOne02() throws Exception {
        assertThat(processor.stepsPartOne(12), is(3));
    }

    @Test
    public void stepsPartOne03() throws Exception {
        assertThat(processor.stepsPartOne(23), is(2));
    }

    @Test
    public void stepsPartOne04() throws Exception {
        assertThat(processor.stepsPartOne(1024), is(31));
    }
}