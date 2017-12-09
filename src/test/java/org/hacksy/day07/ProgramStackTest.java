package org.hacksy.day07;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProgramStackTest {
    ProgramStack stack;

    @Before
    public void setup() {
        stack = new ProgramStack();
    }

    @Test
    public void test01() {
        stack.addToMap("pbga", 66, Collections.EMPTY_LIST);
        stack.addToMap("xhth", 57, Collections.EMPTY_LIST);
        stack.addToMap("ebii", 61, Collections.EMPTY_LIST);
        stack.addToMap("havc", 66, Collections.EMPTY_LIST);
        stack.addToMap("ktlj", 57, Collections.EMPTY_LIST);
        stack.addToMap("fwft", 72, Lists.newArrayList("ktlj", "cntj", "xhth"));
        stack.addToMap("qoyq", 66, Collections.EMPTY_LIST);
        stack.addToMap("padx", 45, Lists.newArrayList("pbga", "havc", "qoyq"));
        stack.addToMap("tknk", 41, Lists.newArrayList("ugml", "padx", "fwft"));
        stack.addToMap("jptl", 61, Collections.EMPTY_LIST);
        stack.addToMap("ugml", 68, Lists.newArrayList("gyxo", "ebii", "jptl"));
        stack.addToMap("gyxo", 61, Collections.EMPTY_LIST);
        stack.addToMap("cntj", 57, Collections.EMPTY_LIST);

        assertThat(stack.getProgram("ugml").getCalculatedWeight(), is(251));
        assertThat(stack.getProgram("padx").getCalculatedWeight(), is(243));
        assertThat(stack.getProgram("fwft").getCalculatedWeight(), is(243));
        assertThat(stack.getProgram("pbga").getCalculatedWeight(), is(66));
    }

    @Test
    public void test02() {
        stack.addToMap("pbga", 66, Collections.EMPTY_LIST);
        stack.addToMap("xhth", 57, Collections.EMPTY_LIST);
        stack.addToMap("ebii", 61, Collections.EMPTY_LIST);
        stack.addToMap("havc", 66, Collections.EMPTY_LIST);
        stack.addToMap("ktlj", 57, Collections.EMPTY_LIST);
        stack.addToMap("fwft", 72, Lists.newArrayList("ktlj", "cntj", "xhth"));
        stack.addToMap("qoyq", 66, Collections.EMPTY_LIST);
        stack.addToMap("padx", 45, Lists.newArrayList("pbga", "havc", "qoyq"));
        stack.addToMap("tknk", 41, Lists.newArrayList("ugml", "padx", "fwft"));
        stack.addToMap("jptl", 61, Collections.EMPTY_LIST);
        stack.addToMap("ugml", 68, Lists.newArrayList("gyxo", "ebii", "jptl"));
        stack.addToMap("gyxo", 61, Collections.EMPTY_LIST);
        stack.addToMap("cntj", 57, Collections.EMPTY_LIST);

        assertThat(stack.getBase().getName(), is("tknk"));
    }
}