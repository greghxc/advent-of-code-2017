package org.hacksy.day22;

import com.google.common.primitives.Chars;
import org.hacksy.util.FileUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day22Processor {
    public enum Status {
        CLEAN, WEAKENED, INFECTED, FLAGGED
    }

    Integer partOne(File file, Point start, Integer iterations) {
        Map<Point, Status> grid = populateGrid(FileUtil.fileToStringList(file));
        Worm worm = new Worm(start);
        Integer count = 0;

        for (int i = 0; i < iterations; i++) {
            if (grid.get(worm.getCurrentPoint()) == Status.INFECTED) {
                worm.turnRight();
            } else {
                worm.turnLeft();
            }
            grid = flipPoint(grid, worm.getCurrentPoint());
            if (grid.get(worm.getCurrentPoint()) == Status.INFECTED) {
                count++;
            }
            worm.stepForward();
        }

        return count;
    }

    Integer partTwo(File file, Point start, Integer iterations) {
        Map<Point, Status> grid = populateGrid(FileUtil.fileToStringList(file));
        Worm worm = new Worm(start);
        Integer count = 0;

        for (int i = 0; i < iterations; i++) {
            worm = wormSpinnerPartTwo(worm, grid.getOrDefault(worm.getCurrentPoint(), Status.CLEAN));
            grid = flipPointPartTwo(grid, worm.getCurrentPoint());
            if (grid.get(worm.getCurrentPoint()) == Status.INFECTED) {
                count++;
            }
            worm.stepForward();
        }

        return count;
    }

    Map<Point, Status> populateGrid(List<String> lines) {
        Map<Point, Status> grid = new HashMap<>();
        for (int y = 0; y < lines.size(); y++) {
            List<Character> chars = Chars.asList(lines.get(y).toCharArray());
            for (int x = 0; x < chars.size(); x++) {
                if (chars.get(x) == "#".toCharArray()[0]) {
                    grid.put(new Point(x, y * -1), Status.INFECTED);
                }
            }
        }
        return grid;
    }

    Map<Point, Status> flipPoint(Map<Point, Status> grid , Point point) {
        grid.put(point, grid.get(point) == Status.INFECTED ? Status.CLEAN : Status.INFECTED);
        return grid;
    }

    Worm wormSpinnerPartTwo(Worm worm, Status status){
        switch (status) {
            case INFECTED:
                worm.turnRight();
                break;
            case CLEAN:
                worm.turnLeft();
                break;
            case FLAGGED:
                worm.turnRight();
                worm.turnRight();
                break;
            case WEAKENED:
                break;
        }
        return worm;
    }

    Map<Point, Status> flipPointPartTwo(Map<Point, Status> grid , Point point) {
        switch (grid.getOrDefault(point, Status.CLEAN)) {
            case INFECTED:
                grid.put(point, Status.FLAGGED);
                break;
            case CLEAN:
                grid.put(point, Status.WEAKENED);
                break;
            case FLAGGED:
                grid.put(point, Status.CLEAN);
                break;
            case WEAKENED:
                grid.put(point, Status.INFECTED);
                break;
        }
        return grid;
    }
}
