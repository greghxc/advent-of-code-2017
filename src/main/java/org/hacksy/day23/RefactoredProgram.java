package org.hacksy.day23;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefactoredProgram {
    Integer val1 = 100;
    Integer val2 = -100000;
    Integer val3 = -17000;

    Map<String, Long> registers;

    RefactoredProgram() {
        registers = new HashMap<>();
    }

    void setReg(String key, Long value) {
        registers.put(key, value);
    }

    Long getReg(String key) {
        return registers.getOrDefault(key, 0L);
    }

    void partA() {
        do {
            if (getReg("b") % getReg("d") == 0) { setReg("f", 0L); }
            setReg("e", getReg("b"));
        } while (!getReg("e").equals(getReg("b")));
    }

    void partB() {
        do {
            setReg("e", 2L);
            partA();
            setReg("d", getReg("d") + 1);
        } while (!getReg("d").equals(getReg("b")));
    }

    void partC() {
        do {
            setReg("f", 1L);
            setReg("d", 2L);
            partB();
            if (getReg("f") == 0) { setReg("h", getReg("h") + 1); }
            setReg("b", getReg("b") + 17);
        } while (!getReg("c").equals(getReg("b") - 17));
        System.out.println("Finishing C!");
    }

    Long partTwo() {
        setReg("b", 57L * val1 - val2);
        setReg("c", 57L * val1 - val2 - val3);

        partC();

         printRegisters();

        return getReg("h");
    }

    void printRegisters() {
        System.out.println("------");
        List<String> keys = Lists.newArrayList("a", "b", "c", "d", "e", "f", "g", "h");
        for(String key : keys) {
            System.out.println(String.format("%s: %s", key, registers.getOrDefault(key, 0L)));
        }
    }
}
