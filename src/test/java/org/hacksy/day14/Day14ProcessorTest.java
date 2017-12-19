package org.hacksy.day14;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day14ProcessorTest {
    Day14Processor processor;

    @Before
    public void setup() {
        processor = new Day14Processor();
    }

    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne("flqrgnkx"), is(8108));
    }

    @Test
    public void partTwo() {
        assertThat(processor.partTwo("flqrgnkx"), is(1242));
    }
    @Test
    public void hexToBin() {
        System.out.println(processor.hexToBinString("012"));
    }
}