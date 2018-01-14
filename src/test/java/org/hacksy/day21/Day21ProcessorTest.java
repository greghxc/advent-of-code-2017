package org.hacksy.day21;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day21ProcessorTest {
    Day21Processor processor;
    File file;

    @Before
    public void setup() throws Exception {
        processor = new Day21Processor();
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource("day21/input.txt").getFile());
    }

    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(file, 2), is(12));
    }

    @Test
    public void gridBreaker01() {
        String fourBy = "1111/2222/3333/4444";
        assertThat(processor.gridBreaker(fourBy), contains("1122", "1122", "3344", "3344"));
    }

    @Test
    public void gridBreaker02() {
        String sixBy = "111111/222222/333333/444444/555555/666666";
        assertThat(processor.gridBreaker(sixBy), contains("1122", "1122", "1122", "3344", "3344", "3344", "5566", "5566", "5566"));
    }

    @Test
    public void gridBreaker03() {
        String sixBy = "111111111/222222222/333333333/444444444/555555555/666666666/777777777/888888888/999999999";
        assertThat(processor.gridBreaker(sixBy).size(), is(9));
    }

    @Test
    public void stringify02() {
        String grid1 = "AAABBBCCC";
        String grid2 = "AAABBBCCC";
        String grid3 = "DDDEEEFFF";
        String grid4 = "DDDEEEFFF";

        List<String> grids = Lists.newArrayList(grid1, grid2, grid3, grid4);

        String expectedString = "AAAAAABBBBBBCCCCCCDDDDDDEEEEEEFFFFFF";

        assertThat(processor.strigify(grids), is(expectedString));
    }
}