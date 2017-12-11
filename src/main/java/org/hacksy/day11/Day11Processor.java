package org.hacksy.day11;

import org.hacksy.util.FileUtil;

import java.io.File;

class Day11Processor {
    Integer partOne(File input) {
        return processLine(FileUtil.fileToStringList(input).get(0));
    }

    Integer partTwo(File input) {
        return processLineTwo(FileUtil.fileToStringList(input).get(0));
    }

    Integer processLine(String line) {
        HexGrid grid = new HexGrid();
        for( String direction : line.split(",")) {
            grid.increment(direction);
        }
        return grid.distance();
    }

    Integer processLineTwo(String line) {
        HexGrid grid = new HexGrid();
        Integer maxDistance = 0;
        for( String direction : line.split(",")) {
            grid.increment(direction);
            if (grid.distance() > maxDistance) { maxDistance = grid.distance(); }
        }
        return maxDistance;
    }
    
}
