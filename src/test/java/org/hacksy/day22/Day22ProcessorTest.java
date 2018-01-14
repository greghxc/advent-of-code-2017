package org.hacksy.day22;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Day22ProcessorTest {
    Day22Processor processor;
    File file;

    @Before
    public void setup() {
        processor = new Day22Processor();
        ClassLoader classLoader = getClass().getClassLoader();
        file =  new File(classLoader.getResource("day22/input.txt").getFile());
    }

    @Test
    public void hashTest() {
        Map<Point, Boolean> map = new HashMap<>();
        map.put(new Point(0, 0), true);
        assertThat(map.containsKey(new Point(0,0)), is(true));
    }

    @Test
    public void loadFileTest() {
        Day22Processor processor = new Day22Processor();
        List<String> strings = Lists.newArrayList(
                ".#...",
                "...#.",
                "#....",
                "....#",
                "..#.."
        );
        assertThat(processor.populateGrid(strings).size(), is(5));
    }

    @Test
    public void flipTest01() {
        Day22Processor processor = new Day22Processor();
        List<String> strings = Lists.newArrayList(
                "...",
                "...",
                "..."
        );
        assertThat(processor.flipPoint(processor.populateGrid(strings), new Point(1, 1)).size(), is(1));
    }

    @Test
    public void partOne01() {
        assertThat(processor.partOne(file, new Point(1, -1), 10000), is(5587));
    }

    @Test
    public void partTwo01() {
        assertThat(processor.partTwo(file, new Point(1, -1), 100), is(26));
    }

    @Test
    public void partTwo02() {
        assertThat(processor.partTwo(file, new Point(1, -1), 10000000), is(2511944));
    }
}