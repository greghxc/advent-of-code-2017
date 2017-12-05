package org.hacksy.day03;

import org.junit.Before;
import org.junit.Test;

import java.awt.Point;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day03ProcessorTest {
    private Day03Processor processor;

    @Before
    public void setup(){
        processor = new Day03Processor();
    }

    @Test
    public void stepsPartOne01() throws Exception {
        assertThat(processor.partOne(1), is(0));
    }

    @Test
    public void stepsPartOne02() throws Exception {
        assertThat(processor.partOne(12), is(3));
    }

    @Test
    public void stepsPartOne03() throws Exception {
        assertThat(processor.partOne(23), is(2));
    }

    @Test
    public void stepsPartOne04() throws Exception {
        assertThat(processor.partOne(1024), is(31));
    }

    @Test
    public void indexToPoint01() throws Exception {
        assertThat(processor.indexToPoint(12), is(new Point( 2,  2)));
        assertThat(processor.indexToPoint(24), is(new Point( 2, -2)));
        assertThat(processor.indexToPoint(19), is(new Point(-2, -1)));
        assertThat(processor.indexToPoint(13), is(new Point( 1,  2)));
    }

    @Test
    public void neighborsTest01() throws Exception {
        List<Point> neighbors = processor.neighborsFrom(new Point(0,0));
        assertThat(neighbors, contains(
                new Point(1,0),
                new Point(1,1),
                new Point(0,1),
                new Point(-1,1),
                new Point(-1,0),
                new Point(-1,-1),
                new Point(0,-1),
                new Point(1,-1)
        ));
    }

    @Test
    public void neighborsTest02() throws Exception {
        List<Point> neighbors = processor.neighborsFrom(new Point(5,5));
        assertThat(neighbors, contains(
                new Point(6,5),
                new Point(6,6),
                new Point(5,6),
                new Point(4,6),
                new Point(4,5),
                new Point(4,4),
                new Point(5,4),
                new Point(6,4)
        ));
    }

    @Test
    public void partTwoTest01() throws Exception {
        assertThat(processor.partTwo(500), is(747));
    }

    @Test
    public void partTwoTest02() throws Exception {
        assertThat(processor.partTwo(100), is(122));
    }

    @Test
    public void partTwoTest03() throws Exception {
        assertThat(processor.partTwo(800), is(806));
    }
}