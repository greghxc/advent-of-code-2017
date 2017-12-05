package org.hacksy.day03;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GridStepperTest {
    GridStepper stepper;

    @Before
    public void setup() {
        stepper = new GridStepper(new Point(0,0));
    }

    @Test
    public void peekLeft() throws Exception {
        assertThat(stepper.peekLeft(), is(new Point(0,1)));
    }

    @Test
    public void turnLeft() throws Exception {
        stepper.turnLeft();
        stepper.stepForward();
        assertThat(stepper.getCurrentPosition(), is(new Point(0,1)));
    }

    @Test
    public void stepForward() throws Exception {
        stepper.stepForward();
        stepper.stepForward();
        assertThat(stepper.getCurrentPosition(), is(new Point(2,0)));
    }

    @Test
    public void getCurrentPosition() throws Exception {
        assertThat(stepper.getCurrentPosition(), is(new Point(0,0)));
    }
}