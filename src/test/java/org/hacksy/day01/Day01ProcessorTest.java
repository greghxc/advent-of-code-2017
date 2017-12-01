package org.hacksy.day01;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day01ProcessorTest {
    Day01Processor processor;

    @Before
    public void setUp() {
        processor = new Day01Processor();
    }

    @Test
    public void partOne01() throws Exception {
        assertThat(processor.partOne("1122"), is(3));
    }

    @Test
    public void partOne02() throws Exception {
        assertThat(processor.partOne("1111"), is(4));
    }

    @Test
    public void partOne03() throws Exception {
        assertThat(processor.partOne("1234"), is(0));
    }

    @Test
    public void partOne04() throws Exception {
        assertThat(processor.partOne("91212129"), is(9));
    }

    @Test
    public void partTwo01() throws Exception {
        assertThat(processor.partTwo("1212"), is(6));
    }

    @Test
    public void partTwo02() throws Exception {
        assertThat(processor.partTwo("1221"), is(0));
    }

    @Test
    public void partTwo03() throws Exception {
        assertThat(processor.partTwo("123425"), is(4));
    }

    @Test
    public void partTwo04() throws Exception {
        assertThat(processor.partTwo("123123"), is(12));
    }

    @Test
    public void partTwo05() throws Exception {
        assertThat(processor.partTwo("12131415"), is(4));
    }
}