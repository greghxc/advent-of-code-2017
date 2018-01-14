package org.hacksy.day21;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TransformerTest {
    @Test
    public void transform01() throws Exception {
        Transformer transformer = new Transformer();
        transformer.addRule("../.#", "##./#../...");
        transformer.addRule(".#./..#/###", "#..#/..../..../#..#");
        assertThat(transformer.transform(".#...####"), is("#..#........#..#"));
    }
    @Test
    public void transform02() throws Exception {
        Transformer transformer = new Transformer();
        transformer.addRule("../.#", "##./#../...");
        transformer.addRule(".#./..#/###", "#..#/..../..../#..#");
        assertThat(transformer.transform("#..."), is("##.#....."));
    }

    @Test
    public void getAllRotations01() throws Exception {
        Transformer transformer = new Transformer();
        String input = "ABCD";
        assertThat(transformer.getAllRotations(input), containsInAnyOrder("ABCD", "BDAC", "DCBA", "CADB"));
    }

    @Test
    public void rotate01() throws Exception {
        Transformer transformer = new Transformer();
        String input = "ABCD";
        assertThat(transformer.rotate(input), is("BDAC"));
    }

    @Test
    public void rotate02() throws Exception {
        Transformer transformer = new Transformer();
        String input = "BDAC";
        assertThat(transformer.rotate(input), is("DCBA"));
    }

    @Test
    public void rotate03() throws Exception {
        Transformer transformer = new Transformer();
        String input = "ABCDEFGHI";
        assertThat(transformer.rotate(input), is("CFIBEHADG"));
    }

    @Test
    public void rotate04() throws Exception {
        Transformer transformer = new Transformer();
        List<String> rotations = transformer.getAllRotations(".#...####");
        assertThat(rotations.contains(".#.#..###"), is(true));
        assertThat(rotations.contains("###..#.#."), is(true));
        assertThat(rotations.contains("#..#.###."), is(true));
    }
}