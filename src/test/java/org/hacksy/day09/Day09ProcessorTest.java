package org.hacksy.day09;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day09ProcessorTest {
    private Day09Processor processor;
    private File file;

    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();

        processor = new Day09Processor();
        file = new File(classLoader.getResource("day09/input.txt").getFile());
    }

    @Test
    public void partOne() throws Exception {
    }

    @Test
    public void partTwo() throws Exception {
    }

    @Test
    public void line01() {
        assertThat(processor.stringProc("{}", (val, _val) -> val), is(1));
    }
    @Test
    public void line02() {
        assertThat(processor.stringProc("{{{}}}", (val, _val) -> val), is(6));
    }
    @Test
    public void line03() {
        assertThat(processor.stringProc("{{},{}}", (val, _val) -> val), is(5));
    }
    @Test
    public void line04() {
        assertThat(processor.stringProc("{{{},{},{{}}}}", (val, _val) -> val), is(16));
    }
    @Test
    public void line08() {
        assertThat(processor.stringProc("{<a>,<a>,<a>,<a>}", (val, _val) -> val), is(1));
    }
    @Test
    public void line05() {
        assertThat(processor.stringProc("{{<ab>},{<ab>},{<ab>},{<ab>}}", (val, _val) -> val), is(9));
    }
    @Test
    public void line06() {
        assertThat(processor.stringProc("{{<!!>},{<!!>},{<!!>},{<!!>}}", (val, _val) -> val), is(9));
    }
    @Test
    public void line07() {
        assertThat(processor.stringProc("{{<a!>},{<a!>},{<a!>},{<ab>}}", (val, _val) -> val), is(3));
    }
}