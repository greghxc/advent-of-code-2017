package org.hacksy.day23;

import com.google.common.collect.Lists;
import lombok.Data;
import org.hacksy.day18.NoMessageException;
import org.hacksy.day18.Queue;
import org.hacksy.util.FileUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Program {
    Map<String, Long> registers;
    Long currentInstruction;
    List<Instruction> instructions;
    Integer mulCount = 0;

    Program(Integer programId, File file) {
        instructions = fileToInstructions(file);

        registers = new HashMap<>();
        currentInstruction = 0L;

        registers.put("a", Long.valueOf(1));
    }

    boolean hasNext() {
        return currentInstruction >= 0 && currentInstruction < instructions.size();
    }

    boolean executeNext() {
        if (!hasNext()) { return false; }
        try {
            System.out.println(String.format("%s: %s", currentInstruction.intValue(), instructions.get(currentInstruction.intValue())));
            execute(instructions.get(currentInstruction.intValue()));
            printRegisters();
        } catch (NoMessageException nme) {
            return false;
        }
        return true;
    }

    void set(String x, String y) {
        registers.put(x, valOf(y));
        currentInstruction++;
    }
    void sub(String x, String y) {
        registers.put(x, valOf(x) - valOf(y));
        currentInstruction++;
    }
    void mul(String x, String y) {
        registers.put(x, valOf(x) * valOf(y));
        currentInstruction++;
        mulCount++;
    }
    void jnz(String x, String y) {
        if (valOf(x) != 0) {
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

    void execute(Instruction instruction) throws NoMessageException {
        if(instruction.getInsType().equals("snd") || instruction.getX().equals("p")){
            System.out.println("Executing: " + instruction.toString());
            System.out.println("x: " + valOf(instruction.getX()));
            System.out.println("y: " + valOf(instruction.getY()));
        }
        switch(instruction.getInsType()) {
            case "set":
                set(instruction.getX(), instruction.getY());
                break;
            case "sub":
                sub(instruction.getX(), instruction.getY());
                break;
            case "mul":
                mul(instruction.getX(), instruction.getY());
                break;
            case "jnz":
                jnz(instruction.getX(), instruction.getY());
                break;
        }
    }

    void printRegisters() {
        List<String> keys = Lists.newArrayList("a", "b", "c", "d", "e", "f", "g", "h");
        for(String key : keys) {
            System.out.println(String.format("%s: %s", key, registers.getOrDefault(key, 0L)));
        }
    }

    @Data
    class Instruction {
        final String insType;
        final String x;
        final String y;

        public String toString() {
            return String.format("%s %s %s", insType, x, y);
        }
    }
}
