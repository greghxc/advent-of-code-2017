package org.hacksy.day09;

import org.hacksy.util.FileUtil;

import java.io.File;
import java.util.function.BiFunction;

public class Day09Processor {
    String partOne(File file) {
        BiFunction<Integer, Integer, Integer> calc = (val, _val) -> val;
        return String.valueOf(stringProc(FileUtil.fileToStringList(file).get(0), calc));
    }
    String partTwo(File file) {
        BiFunction<Integer, Integer, Integer> calc = (_val, val) -> val;
        return String.valueOf(stringProc(FileUtil.fileToStringList(file).get(0), calc));
    }

    Integer stringProc(String input, BiFunction<Integer, Integer, Integer> result) {
        char[] charArray = input.toCharArray();
        boolean garbageState = false;
        boolean ignoreState = false;
        int openChunks = 0;
        int count = 0;
        int garbageCount = 0;

        for(char c: charArray) {
            if(garbageState) {
               if(ignoreState) {
                   ignoreState = false;
               } else {
                   switch (String.valueOf(c)) {
                       case ">":
                           garbageState = false;
                           break;
                       case "!":
                           ignoreState = true;
                           break;
                       default:
                           garbageCount++;
                           break;
                   }
               }
            } else {
                switch (String.valueOf(c)) {
                    case "{":
                        openChunks++;
                        break;
                    case "}":
                        if (openChunks > 0) {
                            count += openChunks;
                            openChunks--;
                        }
                        break;
                    case "<":
                        garbageState = true;
                        break;
                }

            }
        }
        return result.apply(count, garbageCount);
    }
}
