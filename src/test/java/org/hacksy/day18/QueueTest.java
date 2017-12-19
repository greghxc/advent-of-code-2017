package org.hacksy.day18;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void addMsg() throws Exception {
        Queue q = new Queue();
        assertThat(q.hasNext(), is(false));
        q.addMsg(1);
        assertThat(q.hasNext(), is(true));
        assertThat(q.getMsg(), is(1));
        assertThat(q.hasNext(), is(false));
        q.addMsg(2);
        q.addMsg(3);
        assertThat(q.hasNext(), is(true));
        assertThat(q.getMsg(), is(2));
        assertThat(q.hasNext(), is(true));
        assertThat(q.getMsg(), is(3));
        assertThat(q.hasNext(), is(false));
    }
}