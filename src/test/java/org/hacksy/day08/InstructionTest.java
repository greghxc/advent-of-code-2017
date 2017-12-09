package org.hacksy.day08;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.*;

public class InstructionTest {
    @Test
    public void from() throws Exception {
        Instruction ins = Instruction.from("c dec -10 if a >= 1");
        assertThat(ins, isA(Instruction.class));
    }

    @Test
    public void getRegister() throws Exception {
        Instruction ins = Instruction.from("c dec -10 if a >= 1");
        assertThat(ins.getRegister(), is("c"));
    }

    @Test
    public void getCompRegister() throws Exception {
        Instruction ins = Instruction.from("c dec -10 if a >= 1");
        assertThat(ins.getCompRegister(), is("a"));
    }

    @Test
    public void getMod() throws Exception {
        Instruction ins = Instruction.from("c dec -10 if a >= 1");
        assertThat(ins.getMod(), is(-10));
    }

    @Test
    public void getModType() throws Exception {
        Instruction ins = Instruction.from("c dec -10 if a >= 1");
        assertThat(ins.getModType(), is("dec"));
    }

    @Test
    public void getCompType() throws Exception {
        Instruction ins = Instruction.from("c dec -10 if a >= 1");
        assertThat(ins.getCompType(), is(">="));
    }

    @Test
    public void getCompVal() throws Exception {
        Instruction ins = Instruction.from("c dec -10 if a >= 1");
        assertThat(ins.getCompVal(), is(1));
    }

    @Test
    public void eval01() {
        Instruction ins = Instruction.from("c dec -10 if a >= 1");
        assertThat(ins.eval(5, 6), is(15));
    }

    @Test
    public void eval02() {
        Instruction ins = Instruction.from("c dec -10 if a >= 1");
        assertThat(ins.eval(5, 0), is(5));
    }
}