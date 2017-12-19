package org.hacksy.day16;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day16ProcessorTest {
    Day16Processor processor;
    File file;

    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();

        processor = new Day16Processor();
        file =  new File(classLoader.getResource("day16/input.txt").getFile());
    }

    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(file, "abcde"), is("baedc"));
    }

    @Test
    public void partTwo01() {
        assertThat(processor.partTwo(file, "abcde", 1), is("baedc"));
    }

    @Test
    public void partTwo02() {
        assertThat(processor.partTwo(file, "abcde", 2), is("ceadb"));
    }

    @Test
    public void partTwo03() {
        assertThat(processor.partTwo(file, "abcde", 95), is("ecbda"));
    }

    @Test
    public void partTwoBrute01() {
        assertThat(processor.partTwoBrute(file, "abcde", 1), is("baedc"));
    }

    @Test
    public void partTwoBrute02() {
        assertThat(processor.partTwoBrute(file, "abcde", 2), is("ceadb"));
    }

    @Test
    public void partTwoBrute03() {
        assertThat(processor.partTwoBrute(file, "abcde", 95), is("ecbda"));
    }
}