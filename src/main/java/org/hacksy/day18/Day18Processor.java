package org.hacksy.day18;

import lombok.Data;
import org.hacksy.util.FileUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day18Processor {
    Map<String, Long> registers;
    Long currentInstruction;
    Long lastPlayed;
    Long recovered;

    Long partOne(File file) {
        List<Instruction> instructions = fileToInstructions(file);

        registers = new HashMap<>();
        currentInstruction = 0L;
        lastPlayed = null;
        recovered = null;

        while (currentInstruction >= 0 && currentInstruction < instructions.size() && recovered == null) {
            execute(instructions.get(currentInstruction.intValue()));
        }

        return recovered;
    }

//    snd X plays a sound with a frequency equal to the value of X.
    void snd(String x) {
        lastPlayed = valOf(x);
        currentInstruction++;
    }
//    set X Y sets register X to the value of Y.
    void set(String x, String y) {
        registers.put(x, valOf(y));
        currentInstruction++;

    }
//    add X Y increases register X by the value of Y.
    void add(String x, String y) {
        registers.put(x, valOf(x) + valOf(y));
        currentInstruction++;
    }
//    mul X Y sets register X to the result of multiplying the value contained in register X by the value of Y.
    void mul(String x, String y) {
        registers.put(x, valOf(x) * valOf(y));
        currentInstruction++;
    }
//    mod X Y sets register X to the remainder of dividing the value contained in register X by the value of Y (that is, it sets X to the result of X modulo Y).
    void mod(String x, String y) {
        registers.put(x, valOf(x) % valOf(y));
        currentInstruction++;
    }
//    rcv X recovers the frequency of the last sound played, but only when the value of X is not zero. (If it is zero, the command does nothing.)
    void rcv(String x) {
        if (valOf(x) != 0) {
            recovered = lastPlayed;
        }
        currentInstruction++;
    }
//    jgz X Y jumps with an offset of the value of Y, but only if the value of X is greater than zero. (An offset of 2 skips the next instruction, an offset of -1 jumps to the previous instruction, and so on.)
    void jgx(String x, String y) {
        if (valOf(x) > 0) {
            currentInstruction += valOf(y);
        } else {
            currentInstruction++;

        }
    }
    Long valOf(String z) {
        if (z != null) {
            return z.matches("[a-z]+") ? registers.getOrDefault(z, 0L) : Long.parseLong(z);
        }
        return null;
    }

    List<Instruction> fileToInstructions(File file) {
        return FileUtil.fileToStringList(file).stream()
                .map((line) -> (line.split("\\s")))
                .map((parts) -> new Instruction(
                            parts[0],
                            parts[1],
                            parts.length > 2 ? parts[2] : null
                    ))
                .collect(Collectors.toList());
    }

    void execute(Instruction instruction) {
        if(instruction.getInsType().equals("snd") || instruction.getX().equals("p")){
            System.out.println("Executing: " + instruction.toString());
            System.out.println("x: " + valOf(instruction.getX()));
            System.out.println("y: " + valOf(instruction.getY()));
        }
        switch(instruction.getInsType()) {
            case "snd":
                snd(instruction.getX());
                break;
            case "set":
                set(instruction.getX(), instruction.getY());
                break;
            case "add":
                add(instruction.getX(), instruction.getY());
                break;
            case "mul":
                mul(instruction.getX(), instruction.getY());
                break;
            case "mod":
                mod(instruction.getX(), instruction.getY());
                break;
            case "rcv":
                rcv(instruction.getX());
                break;
            case "jgz":
                jgx(instruction.getX(), instruction.getY());
                break;
        }
    }

    @Data
    class Instruction {
        final String insType;
        final String x;
        final String y;

        String asString() {
            return String.format("%s %s %s", insType, x, y);
        }
    }
}
