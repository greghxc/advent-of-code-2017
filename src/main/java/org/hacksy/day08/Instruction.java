package org.hacksy.day08;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Data @Builder
class Instruction {
    final String register;
    final Integer mod;
    final String modType;
    final String compType;
    final Integer compVal;
    final String compRegister;

    static Instruction from(String rawLine) {
        String[] parts = rawLine.split("\\s");
        // Sample: c dec -10 if a >= 1
        return Instruction.builder()
                .register(parts[0])
                .compRegister(parts[4])
                .modType(parts[1])
                .mod(Integer.valueOf(parts[2]))
                .compType(parts[5])
                .compVal(Integer.valueOf(parts[6]))
                .build();
    }

    Function<Integer, Boolean> getComparator(String operatorString, Integer compareValue) {
        Map<String, Function<Integer, Boolean>> functions = new HashMap<>();
        functions.put(">", (value) -> value > compareValue);
        functions.put(">=", (value) -> value >= compareValue);
        functions.put("<", (value) -> value < compareValue);
        functions.put("<=", (value) -> value <= compareValue);
        functions.put("==", (value) -> value.equals(compareValue));
        functions.put("!=", (value) -> !value.equals(compareValue));
        return functions.get(operatorString);
    }

    Function<Integer, Integer> getModifier(String operatorString, Integer modValue) {
        Map<String, Function<Integer, Integer>> functions = new HashMap<>();
        functions.put("inc", (orig) -> orig + modValue);
        functions.put("dec", (orig) -> orig - modValue);
        return functions.get(operatorString);
    }

    Integer eval(Integer origRegVal, Integer compRegVal) {
        if (getComparator(compType, compVal).apply(compRegVal)) {
            return getModifier(modType, mod).apply(origRegVal);
        }
        return origRegVal;
    }
}
