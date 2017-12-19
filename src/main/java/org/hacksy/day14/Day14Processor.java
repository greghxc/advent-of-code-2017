package org.hacksy.day14;

import com.google.common.primitives.Chars;
import org.hacksy.day10.Day10Processor;

import java.math.BigInteger;
import java.util.List;

public class Day14Processor {
    Day10Processor hashMaker = new Day10Processor();

    Integer partOne(String input) {
        String string = "";
        for(int i = 0; i < 128; i++) {
            string += hexToBinString(hashMaker.partTwo(input + "-" + i));
        }
        return string.replace("0", "").length();
    }

    Integer partTwo(String input) {
        Grid grid = new Grid(128);
        for(int row = 0; row < 128; row++) {
            List<Character> chars = Chars.asList(hexToBinString(hashMaker.partTwo(input + "-" + row)).toCharArray());
            for (int column = 0; column < 128; column++) {
                if (chars.get(column).toString().equals("1")) {
                    grid.turnOn(grid.coord(row, column));
                }
            }
        }
        return grid.regions();
    }

    String hexToBinString(String input) {
        return Chars.asList(input.toCharArray()).stream()
                .map((c) -> String.format("%4s", new BigInteger(c.toString(), 16).toString(2)).replace(' ', '0'))
                .reduce("", (acc, bin) -> acc + bin);
    }
}
