package org.hacksy.day06;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Day06Processor {
    public int partOne(List<Integer> integerList) {
        return distributeIterator(integerList, (combos) -> combos.size() - 1);
    }

    public int partTwo(List<Integer> integerList) {
        return distributeIterator(integerList, (combos) -> (combos.size() - 1) - combos.indexOf(combos.get(combos.size() - 1)));
    }

    private int distributeIterator(List<Integer> integerList, Function<List, Integer> resultCalculator) {
        List<List<Integer>> seenList = new ArrayList<>();
        List<Integer> lastSeen = integerList;
        while(!seenList.contains(lastSeen)) {
            seenList.add(lastSeen);
            lastSeen = distribute(lastSeen);
        }
        seenList.add(lastSeen);
        return resultCalculator.apply(seenList);
    }

    public List<Integer> distribute(List<Integer> integerList) {
        List<Integer> workingList = Lists.newArrayList(integerList);
        Integer max = Collections.max(workingList);
        Integer index = workingList.indexOf(max);
        workingList.set(index, 0);
        while (max > 0) {
            index = (index + 1) % workingList.size();
            workingList.set(index, workingList.get(index) + 1);
            max = max - 1;
        }
        return workingList;
    }
}
