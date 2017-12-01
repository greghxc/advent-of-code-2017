package org.hacksy.day01;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day01AProcessorTest {
    @Test
    public void input01() throws Exception {
        Day01AProcessor processor = new Day01AProcessor();
        assertThat(processor.run("1122"), is(3));
    }

    @Test
    public void input02() throws Exception {
        Day01AProcessor processor = new Day01AProcessor();
        assertThat(processor.run("1111"), is(4));
    }

    @Test
    public void input03() throws Exception {
        Day01AProcessor processor = new Day01AProcessor();
        assertThat(processor.run("1234"), is(0));
    }

    @Test
    public void input04() throws Exception {
        Day01AProcessor processor = new Day01AProcessor();
        assertThat(processor.run("91212129"), is(9));
    }
}