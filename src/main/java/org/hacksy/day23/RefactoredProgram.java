package org.hacksy.day23;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefactoredProgram {
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


    void chunk01() {
//        set g d
//        mul g e
//        sub g b

//        jnz g 2
//        set f 0

//        sub e -1
//        set g e
//        sub g b
//        jnz g -8

//        setReg("g", 0L);
//        setReg("f", getReg("b") % 2);
//        setReg("e", getReg("b"));

        setReg("a", 1L);
        setReg("b", 201L);
        setReg("c", 1227L);
        setReg("d", 0L);
        setReg("e", 0L);
        setReg("f", 1L);
        setReg("g", 0L);
        setReg("h", 0L);

        Boolean running = true;
        while(running) {
            setReg("g", getReg("d") * getReg("e") - getReg("b"));
            if (getReg("g") == 0) setReg("f", 0L);
            setReg("e", getReg("e") - -1L);
            setReg("g", getReg("e") - getReg("b"));
            printRegisters();
            running = getReg("g") != 0;
        }
    }

    void chunk02() {
//        chunk02: set e 2
//        chunk01
//        sub d -1
//        set g d
//        sub g b
//        jnz g -13 /chunk02

//        setReg("a", 1L);
//        setReg("b", 10L);
//        setReg("c", 122700L);
//        setReg("d", 2L);
//        setReg("e", 0L);
//        setReg("f", 1L);
//        setReg("g", 0L);
//        setReg("h", 0L);
//
//        Boolean running = true;
//        while(running) {
//            setReg("e", 2L);
//            chunk01();
//            setReg("d", getReg("d") + 1);
//            setReg("g", getReg("d") - getReg("b"));
//            printRegisters();
//            running = getReg("g") != 0;
//        }
        setReg("d", getReg("b"));
        setReg("e", getReg("b"));
        setReg("f", getReg("b") % 2);
        setReg("g", 0L);
    }

    void chunk03() {
        setReg("b", 57L);
        setReg("c", getReg("b"));
        setReg("b", getReg("b") * 1000);
        setReg("b", getReg("b") + 100000);
        setReg("c", getReg("b"));
        setReg("c", getReg("c") + 17000);

        Boolean running = true;
        while(running) {
            setReg("f", 1L);

            if (getReg("b") % 2 == 0) setReg("f", 0L);
            setReg("e", getReg("b"));
            setReg("d", getReg("b"));

            if (getReg("f") == 0) setReg("h", getReg("h") + 1);

            setReg("g", getReg("b"));
            setReg("g", getReg("g") - getReg("c"));

            if (getReg("g") != 0) {
                setReg("b", getReg("b") + 17);
            } else {
                running = false;
            }

            printRegisters();
        }
    }

    void printRegisters() {
        System.out.println("------");
        List<String> keys = Lists.newArrayList("a", "b", "c", "d", "e", "f", "g", "h");
        for(String key : keys) {
            System.out.println(String.format("%s: %s", key, registers.getOrDefault(key, 0L)));
        }
    }
}
