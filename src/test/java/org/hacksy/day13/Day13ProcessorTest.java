package org.hacksy.day13;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day13ProcessorTest {
    Day13Processor processor;
    File file;

    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource("day13/input.txt").getFile());
        processor = new Day13Processor();
    }
    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(file), is(24));
    }

    @Test
    public void partTwo() throws Exception {
        assertThat(processor.partTwo(file), is(10));
    }

    @Test
    public void timeTest01() {
        Stopwatch timer = Stopwatch.createStarted();
        for (int i = 0; i < 100000; i++) {
            "6: 11".split("[\\s:]+");
        }
        System.out.println("timeTest01:" + timer.stop());
    }

    @Test
    public void timeTest02() {
        List<String> nums = Lists.newArrayList("6", "11");
        Stopwatch timer = Stopwatch.createStarted();
        for (int i = 0; i < 100000; i++) {
            nums.stream().map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        System.out.println("timeTest02:" + timer.stop());
    }

    @Test
    public void timeTest03() {
        String[] nums = new String[]{"6", "11"};
        Stopwatch timer = Stopwatch.createStarted();
        for (int i = 0; i < 100000; i++) {
            Arrays.stream(nums);
        }
        System.out.println("timeTest03:" + timer.stop());
    }
}