package org.hacksy.day03;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

class Day03Processor {
    int partOne(int start) {
        Point location = indexToPoint(start - 1);
        return Math.abs(location.x) + Math.abs(location.y);
    }

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

    Point indexToPoint(int index) {
        Map<Point, Integer> pointToIndex = new HashMap<>();
        Map<Integer, Point> indexToPoint = new HashMap<>();
        GridStepper stepper = new GridStepper();

        for(int i = 0; i <= index; i++) {
            pointToIndex.put(stepper.getCurrentPosition(), i);
            indexToPoint.put(i, stepper.getCurrentPosition());
            stepper.stepForward();
            if(!pointToIndex.containsKey(stepper.peekLeft())){stepper.turnLeft();}
        }

        return indexToPoint.get(index);
    }

    List<Point> neighborsFrom(Point centerPoint) {
        GridStepper stepper = new GridStepper(centerPoint);
        List<Point> neighbors = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            neighbors.add(stepper.getCurrentPosition());
            stepper.stepForward();
            if(!neighbors.contains(stepper.peekLeft())){stepper.turnLeft();}
        }

        neighbors.remove(centerPoint);
        return neighbors;
    }
}
