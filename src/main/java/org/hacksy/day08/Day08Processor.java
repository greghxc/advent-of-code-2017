package org.hacksy.day08;

import org.hacksy.util.FileUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Day08Processor {
    Integer partOne(File file) {
        Map<String, Integer> registers = new HashMap<>();
        Integer max = null;

        FileUtil.fileToStringList(file).stream()
                .map(Instruction::from)
                .forEach((ins) -> registers.put(
                        ins.getRegister(),
                        ins.eval(
                                registers.getOrDefault(ins.getRegister(), 0),
                                registers.getOrDefault(ins.getCompRegister(), 0))
                        )
                );
        for (Integer regVal : registers.values()) {
            if ( max == null || regVal > max) {
                max = regVal;
            }
        }
        return max;
    }

    Integer partTwo(File file) {
        Map<String, Integer> registers = new HashMap<>();
        Integer max = null;

        List<Instruction> instructions = FileUtil.fileToStringList(file).stream()
                .map(Instruction::from)
                .collect(Collectors.toList());
        for (Instruction ins : instructions) {
            Integer evalVal = ins.eval(
                    registers.getOrDefault(ins.getRegister(), 0),
                    registers.getOrDefault(ins.getCompRegister(), 0)
            );
            registers.put(ins.getRegister(), evalVal);
            if ( max == null || evalVal > max) {
                max = evalVal;
            }
        }
        return max;
    }
}
