package org.hacksy.day20;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day20ProcessorTest {
    Day20Processor processor;
    File file;

    @Before
    public void setup(){
        processor = new Day20Processor();
        ClassLoader classLoader = getClass().getClassLoader();
        file =  new File(classLoader.getResource("day20/input.txt").getFile());
    }

    @Test
    public void partOne() throws Exception {
        assertThat(processor.partOne(file), is(0));
    }

    @Test
    public void partTwo() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        file =  new File(classLoader.getResource("day20/input2.txt").getFile());
        assertThat(processor.partTwo(file), is(1));
    }

    @Test
    public void particleFrom() throws Exception {
        Particle particle = processor.particleFrom("p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>");
        assertThat(particle.toString(), is("p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>"));
    }

}