package org.hacksy.day11;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day11ProcessorTest {
    Day11Processor processor;

    @Before
    public void setup() {
        processor = new Day11Processor();
    }

    @Test
    public void partOne() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("day11/input.txt").getFile());
        assertThat(processor.partOne(file), is(3));
    }

    @Test
    public void partTwo() throws Exception {
    }

    @Test
    public void processTest01() {
        assertThat(processor.processLine("ne,ne,ne"), is(3));
    }
    @Test
    public void processTest02() {
        assertThat(processor.processLine("ne,ne,sw,sw"), is(0));
    }
    @Test
    public void processTest03() {
        assertThat(processor.processLine("ne,ne,s,s"), is(2));
    }
    @Test
    public void processTest04() {
        assertThat(processor.processLine("se,sw,se,sw,sw"), is(3));
    }
    @Test
    public void processTest05() {
        assertThat(processor.processLine("se"), is(1));
    }
    @Test
    public void processTest06() {
        assertThat(processor.processLine("nw,sw,nw,sw"), is(4));
    }
    @Test
    public void processTest07() {
        assertThat(processor.processLine("nw,ne,nw,ne"), is(2));
    }
}