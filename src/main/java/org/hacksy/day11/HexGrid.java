package org.hacksy.day11;

import java.util.*;
import java.util.stream.Collectors;

public class HexGrid {
    private Map<String, Integer> values;

    HexGrid() {
        values = new HashMap<>();
        for (String key : new String[]{"ne", "n", "nw", "se", "s", "sw"}) {
            values.put(key, 0);
        }
    }

    void increment(String key) {
        values.put(key, values.get(key) + 1);
    }

    Integer distance() {
        while(compress() > 0) {}
        return values.keySet().stream().mapToInt(values::get).sum();
    }

    // I'm certain this can be optimized. But first pass, just loop until we're not doing work anymore.
    private Integer compress() {
        Integer min;
        Integer minTotal = 0;

        min = getMin("se", "sw");
        values.put("se", values.get("se") - min);
        values.put("sw", values.get("sw") - min);
        values.put("s", values.get("s") + min);
        minTotal += min;

        min = getMin("ne", "nw");
        values.put("ne", values.get("ne") - min);
        values.put("nw", values.get("nw") - min);
        values.put("n", values.get("n") + min);
        minTotal += min;

        min = getMin("ne", "s");
        values.put("ne", values.get("ne") - min);
        values.put("s", values.get("s") - min);
        values.put("se", values.get("se") + min);
        minTotal += min;

        min = getMin("nw", "s");
        values.put("nw", values.get("nw") - min);
        values.put("s", values.get("s") - min);
        values.put("sw", values.get("sw") + min);
        minTotal += min;

        min = getMin("se", "n");
        values.put("se", values.get("se") - min);
        values.put("n", values.get("n") - min);
        values.put("ne", values.get("ne") + min);
        minTotal += min;

        min = getMin("sw", "n");
        values.put("sw", values.get("sw") - min);
        values.put("n", values.get("n") - min);
        values.put("nw", values.get("nw") + min);
        minTotal += min;

        min = getMin("ne", "sw");
        values.put("ne", values.get("ne") - min);
        values.put("sw", values.get("sw") - min);
        minTotal += min;

        min = getMin("ne", "sw");
        values.put("ne", values.get("ne") - min);
        values.put("sw", values.get("sw") - min);
        minTotal += min;

        return minTotal;
    }

    private Integer getMin(String ... keys) {
        return Collections.min(Arrays.stream(keys)
                .map(values::get)
                .collect(Collectors.toList()));
    }

}
