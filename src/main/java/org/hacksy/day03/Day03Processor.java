package org.hacksy.day03;

import java.awt.Point;
import java.util.*;
import java.util.function.Function;

class Day03Processor {
    // Reimplemented using stepper. Original pen & paper mathy solution in history.
    int partOne(int start) {
        Point location = indexToPoint(start - 1);
        return Math.abs(location.x) + Math.abs(location.y);
    }

    // Use a stepper to walk the grid. I expect there is an elegant mathy way to do this.
    int partTwo(int maxValue) {
        Point origin = new Point(0,0);
        Map<Point, Integer> pointToValue = new HashMap<>();
        GridStepper stepper = new GridStepper(origin);

        int currentLocationValue = 1;
        pointToValue.put(origin, currentLocationValue);

        while (currentLocationValue < maxValue) {
            Function<Point, Integer> valueCalc = (_origin) -> neighborsFrom(stepper.getCurrentPosition()).stream()
                    .mapToInt((point) -> pointToValue.getOrDefault(point, 0))
                    .sum();
            pointToValue.computeIfAbsent(stepper.getCurrentPosition(), valueCalc);
            currentLocationValue = pointToValue.get(stepper.getCurrentPosition());
            stepper.stepForward();
            if(!pointToValue.containsKey(stepper.peekLeft())){stepper.turnLeft();}
        }
        return currentLocationValue;
    }

    // get coords for any index by walking the grid
    Point indexToPoint(int index) {
        Set<Point> visitedPoints = new HashSet<>();
        GridStepper stepper = new GridStepper();

        for(int i = 0; i < index; i++) {
            visitedPoints.add(stepper.getCurrentPosition());
            stepper.stepForward();
            if(!visitedPoints.contains(stepper.peekLeft())){stepper.turnLeft();}
        }

        return stepper.getCurrentPosition();
    }

    // Sorta hacky, we can use our stepper here to walk around our origin point to find neighbors.
    List<Point> neighborsFrom(Point centerPoint) {
        GridStepper stepper = new GridStepper(centerPoint);
        List<Point> neighbors = new ArrayList<>();

        // 9 is number of steps required to circle a point
        for(int i = 0; i < 9; i++) {
            neighbors.add(stepper.getCurrentPosition());
            stepper.stepForward();
            if(!neighbors.contains(stepper.peekLeft())){stepper.turnLeft();}
        }

        // Origin isn't a neighbor.
        neighbors.remove(centerPoint);
        return neighbors;
    }
}
