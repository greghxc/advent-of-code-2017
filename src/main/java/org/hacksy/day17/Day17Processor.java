package org.hacksy.day17;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Day17Processor {
    Integer partOne(Integer steps, Integer iterations, Integer valAfter) {
        List<Integer> list = Lists.newArrayList(0);
        for (int i = 0; i < iterations; i++) {
            list = step(list, steps, i + 1);
        }
        return list.get(list.indexOf(valAfter) + 1);
    }

    Integer partTwo(Integer steps, Integer iterations) {
        Integer currentLength = 1;
        Integer currentPosition = 0;
        Integer afterZero = 0;

        for (int i = 0; i < iterations; i++) {
            currentPosition = ((currentPosition + steps) % currentLength) + 1;
            currentLength++;
            if(currentPosition == 1) {
                afterZero = i + 1;
            }
        }
        return afterZero;
    }

    private List<Integer> step(List<Integer> list, Integer steps, Integer val) {
        List<Integer> newList = new ArrayList<>();
        newList.add(val);
        newList.addAll(list.subList((steps % list.size()) + 1, list.size()));
        newList.addAll(list.subList(0, (steps % list.size()) + 1));
        return newList;
    }
}
