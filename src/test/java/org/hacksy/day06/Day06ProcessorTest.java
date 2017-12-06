package org.hacksy.day06;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day06ProcessorTest {
    Day06Processor processor;

    @Before
    public void setup() throws Exception {
        processor = new Day06Processor();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("day06/input.txt").getFile());
    }

    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(Lists.newArrayList(0, 2, 7, 0)), is(5));
    }

    @Test
    public void partTwo() throws Exception {
        assertThat(processor.partTwo(Lists.newArrayList(0, 2, 7, 0)), is(4));
    }

    @Test
    public void distribute01() {
        assertThat(processor.distribute(Lists.newArrayList(0, 2, 7, 0)), contains(2, 4, 1, 2));
    }

    @Test
    public void distribute02() {
        assertThat(processor.distribute(Lists.newArrayList(2, 4, 1, 2)), contains(3, 1, 2, 3));
    }

    @Test
    public void distribute03() {
        assertThat(processor.distribute(Lists.newArrayList(3, 1, 2, 3)), contains(0, 2, 3, 4));
    }

    @Test
    public void distribute04() {
        assertThat(processor.distribute(Lists.newArrayList(0, 2, 3, 4)), contains(1, 3, 4, 1));
    }

    @Test
    public void distribute05() {
        assertThat(processor.distribute(Lists.newArrayList(1, 3, 4, 1)), contains(2, 4, 1, 2));
    }
}