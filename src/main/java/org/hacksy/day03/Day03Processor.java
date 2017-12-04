package org.hacksy.day03;

import com.google.common.math.IntMath;

import java.awt.*;
import java.math.RoundingMode;

public class Day03Processor {
    // what I did on paper, but in code. not very program-y.
    // part two requires a different solution, will come back.
    public int stepsPartOne(int start) {
        if (start == 1) { return 0; }

        int root = IntMath.sqrt(start, RoundingMode.UP);
        int lengthOfRow = root - root % 2;
        int origMod = (start - 1) % lengthOfRow;
        int diff = origMod - lengthOfRow / 2;

        return Math.abs(diff) + lengthOfRow / 2;
    }
}
