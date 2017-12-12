package org.hacksy.day12;

import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

class QuickFind {
    private int[] rootMap;
    QuickFind(int length) {
        rootMap = new int[length];
        for(int i = 0; i < rootMap.length; i++) {
            rootMap[i] = i;
        }
    }

    void connect(int a, int b) {
        int aVal = rootMap[a];
        int bVal = rootMap[b];

        if (aVal != bVal) {
            for (int i = 0; i < rootMap.length; i++){
                if (rootMap[i] == aVal) {
                    rootMap[i] = bVal;
                }
            }
        }
    }

    boolean connected(int a, int b) {
        return rootMap[a] == rootMap[b];
    }

    int groups() {
        return Sets.newHashSet(Ints.asList(rootMap)).size();
    }
}
