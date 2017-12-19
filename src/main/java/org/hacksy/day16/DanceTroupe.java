package org.hacksy.day16;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DanceTroupe<T> {
    @Getter List<T> positions;
    Integer spinTally;

    DanceTroupe(List<T> troupe) {
        positions = troupe;
        spinTally = 0;
    }

    void spin(Integer s) {
        spinTally -= s;
    }

    void exchange(Integer a, Integer b) {
        exchangeRaw(convertedIndex(a), convertedIndex(b));
    }

    void partner(T a, T b) {
        exchangeRaw(positions.indexOf(a), positions.indexOf(b));
    }

    List<T> asList() {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            list.add(positions.get(convertedIndex(i)));
        }
        return list;
    }

    private Integer convertedIndex(Integer i) {
        return (positions.size() + (spinTally % positions.size()) + i) % positions.size();
    }

    private void exchangeRaw(Integer a, Integer b) {
        T origA = positions.get(a);
        T origB = positions.get(b);

        positions.set(a, origB);
        positions.set(b, origA);
    }
}