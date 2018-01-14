package org.hacksy.day24;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ComponentTest {
    @Test
    public void hasPort() throws Exception {
        Component component = new Component(1, 1);
        component.usePort(1);
        assertThat(
                Lists.newArrayList(
                    component.hasPort(1),
                    component.hasPort(2)
                ),
                contains(true, false)
        );
    }

    @Test
    public void hasPort02() throws Exception {
        Component component = new Component(1, 2);
        assertThat(
                Lists.newArrayList(
                        component.hasPort(1),
                        component.hasPort(2),
                        component.hasPort(3)
                ),
                contains(true, true, false)
        );
    }

    @Test
    public void usePort() throws Exception {
        Component component = new Component(1, 2);
        component.usePort(1);
        assertThat(
                Lists.newArrayList(
                        component.hasPort(1),
                        component.hasPort(2),
                        component.hasPort(3)
                ),
                contains(false, true, false)
        );

    }

    @Test
    public void getStrength() {
        Component component = new Component(1, 2);
        component.usePort(1);
        assertThat(component.getStrength(), is(3));
    }
}