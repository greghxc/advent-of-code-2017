package org.hacksy.day25;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day25Processor {
    private Map<List<String>, Integer> moveMap;
    private Map<List<String>, Integer> writeMap;
    private Map<List<String>, String> nextMap;
    private Map<Integer, Integer> ribbon;
    private String proceedWith;
    private Integer currentPosition;

    Day25Processor() {
        moveMap = Maps.newHashMap();
        writeMap = Maps.newHashMap();
        nextMap = Maps.newHashMap();

        moveMap.put(Lists.newArrayList("A1", "C0", "D0", "D1", "F0"), -1);
        moveMap.put(Lists.newArrayList("A0", "B0", "B1", "C1", "E0", "E1", "F1"), 1);

        writeMap.put(Lists.newArrayList("A0", "C0", "C1", "E1", "F0", "F1"), 1);
        writeMap.put(Lists.newArrayList("A1", "B0", "B1", "D0", "D1", "E0"), 0);

        nextMap.put(Lists.newArrayList("E0", "F0", "F1"), "A");
        nextMap.put(Lists.newArrayList("A0"), "B");
        nextMap.put(Lists.newArrayList("B0", "E1"), "C");
        nextMap.put(Lists.newArrayList( "B1", "C0", "D1"), "D");
        nextMap.put(Lists.newArrayList("C1", "D0"), "E");
        nextMap.put(Lists.newArrayList("A1"), "F");

        ribbon = Maps.newHashMap();
        proceedWith = "A";
        currentPosition = 0;
    }

    Integer partOne(Integer iterations) {
        for (int i = 0; i < iterations; i++) {
            if (i % 10000 == 0) { System.out.println(i); };
            iterate();
        }

        return ribbon.entrySet().stream()
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    private void iterate() {
        String startingKey = getKey();
        ribbon.put(currentPosition, getValFromMap(writeMap, startingKey));
        currentPosition += getValFromMap(moveMap, startingKey);
        proceedWith = getValFromMap(nextMap, startingKey);
    }

    private String getKey() {
        return String.format("%s%s", proceedWith, ribbon.getOrDefault(currentPosition, 0));
    }

    private <T, U> U getValFromMap(Map<List<T>, U> map, T key) {
        List<U> results = map.entrySet().stream()
                .filter(entry -> entry.getKey().contains(key))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        if (results.size() != 1) {
            throw new RuntimeException(String.format("%s values found for %s", results.size(), key));
        } else {
            return results.get(0);
        }
    }
}
