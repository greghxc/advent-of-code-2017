package org.hacksy.day03;

import com.google.common.collect.Lists;

import java.awt.Point;
import java.util.List;
import java.util.function.Function;

// go fast, turn left
public class GridStepper {
    Point currentPosition;
    int currentForwardFunction;

    List<Function<Point, Point>> forwardFunctions = Lists.newArrayList(
            (Point origin) -> new Point(origin.x + 1, origin.y),
            (Point origin) -> new Point(origin.x , origin.y + 1),
            (Point origin) -> new Point(origin.x - 1, origin.y),
            (Point origin) -> new Point(origin.x, origin.y - 1)
            );

    GridStepper(Point origin) {
        currentPosition = origin;
        currentForwardFunction = 0;
    }
    GridStepper() {
        currentPosition = new Point(0,0);
        currentForwardFunction = 0;
    }

    Function<Point, Point> leftFunction() {
        return forwardFunctions.get((currentForwardFunction + 1) % forwardFunctions.size());
    }

    Function<Point, Point> forwardFunction() {
        return forwardFunctions.get(currentForwardFunction % forwardFunctions.size());
    }

    Point peekLeft() {
        return leftFunction().apply(currentPosition);
    }

    void stepForward() {
        currentPosition = forwardFunction().apply(currentPosition);
    }

    void turnLeft() {
        currentForwardFunction = (currentForwardFunction + 1 % forwardFunctions.size());
    }

    Point getCurrentPosition() {
        return currentPosition;
    }
}
