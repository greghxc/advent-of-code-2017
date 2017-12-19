package org.hacksy.day15;

import lombok.AllArgsConstructor;

import java.util.function.Function;

@AllArgsConstructor
public class Generator {
    Integer factor;
    Integer divisor;
    Function<Integer, Boolean> validator;

    Integer generateValue(Integer baseValue) {
        Integer result = null;
        Integer lastVal = baseValue;
        while (result == null) {
            lastVal = getNextVal(lastVal);
            if (validator.apply(lastVal)) {
                result = lastVal;
            }
        }
        return lastVal;
    }

    Integer getNextVal(Integer baseValue) {
        Long mult = baseValue.longValue() * factor.longValue();
        Long rem = mult % divisor.longValue();
        return Integer.parseInt(Long.toString(rem));
    }
}
