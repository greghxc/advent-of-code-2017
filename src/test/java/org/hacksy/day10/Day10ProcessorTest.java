package org.hacksy.day10;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day10ProcessorTest {
    Day10Processor processor;

    @Before
    public void setup() {
        processor = new Day10Processor();
    }

    @Test
    public void partOne() throws Exception {
        List<Integer> string = Lists.newArrayList( 0, 1, 2, 3, 4);
        List<Integer> jumps = Lists.newArrayList(3, 4, 1, 5);
        assertThat(processor.partOne(string, jumps), is(12));
    }

    @Test
    public void listRoller01() {
        Integer modifier = 124;
        List<Integer> list = Lists.newArrayList(0,1,2,3,4,5,6,7,8,9);
        assertThat(processor.listRoller(processor.listRoller(list, modifier), list.size() - modifier % list.size()), is(list));
    }

    @Test
    public void inputConverter() {
        assertThat(
                processor.prepareInput("1,2,3", Lists.newArrayList(17, 31, 73, 47, 23)),
                is(Lists.newArrayList(49,44,50,44,51,17,31,73,47,23))
        );
    }

    @Test
    public void compressBlock() {
        assertThat(
                processor.compressBlock(Lists.newArrayList(65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22)),
                is(64)
        );
    }

    @Test
    public void hash() {
        assertThat(processor.hash(Lists.newArrayList(64, 7, 255)), is("4007ff"));
    }

    @Test
    public void partTwo() {
        assertThat(processor.partTwo(""), is("a2582a3a0e66e6e86e3812dcb672a272"));
        assertThat(processor.partTwo("AoC 2017"), is("33efeb34ea91902bb2f59c9920caa6cd"));
        assertThat(processor.partTwo("1,2,3"), is("3efbe78a8d82f29979031a4aa0b16a9d"));
        assertThat(processor.partTwo("1,2,4"), is("63960835bcdc130f0b66d7ff4f6a5a8e"));
    }
}