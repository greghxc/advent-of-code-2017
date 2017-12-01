package org.hacksy.day01;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day01BProcessorTest {
    @Test
    public void input01() throws Exception {
        Day01BProcessor processor = new Day01BProcessor();
        assertThat(processor.run("1212"), is(6));
    }

    @Test
    public void input02() throws Exception {
        Day01BProcessor processor = new Day01BProcessor();
        assertThat(processor.run("1221"), is(0));
    }

    @Test
    public void input03() throws Exception {
        Day01BProcessor processor = new Day01BProcessor();
        assertThat(processor.run("123425"), is(4));
    }

    @Test
    public void input04() throws Exception {
        Day01BProcessor processor = new Day01BProcessor();
        assertThat(processor.run("123123"), is(12));
    }

    @Test
    public void input05() throws Exception {
        Day01BProcessor processor = new Day01BProcessor();
        assertThat(processor.run("12131415"), is(4));
    }
}