package org.hacksy.day04;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day04ProcessorTest {
    Day04Processor processor = new Day04Processor();

    @Test
    public void test1() {
        assertThat(processor.validPasswordPartOne("aa bb cc dd ee"), is(true));
        assertThat(processor.validPasswordPartOne("aa bb cc dd aa"), is(false));
        assertThat(processor.validPasswordPartOne(" aa bb cc dd aaa"), is(true));
    }

    @Test
    public void test2() {
        assertThat(processor.validPasswordPartTwo("abcde fghij"), is(true));
        assertThat(processor.validPasswordPartTwo("abcde xyz ecdab"), is(false));
        assertThat(processor.validPasswordPartTwo("a ab abc abd abf abj"), is(true));
        assertThat(processor.validPasswordPartTwo("iiii oiii ooii oooi oooo"), is(true));
        assertThat(processor.validPasswordPartTwo("oiii ioii iioi iiio"), is(false));
    }
}