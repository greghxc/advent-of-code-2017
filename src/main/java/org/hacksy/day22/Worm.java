package org.hacksy.day22;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Function;

public class Worm {
    @Getter @Setter Point currentPoint = new Point(0,0);
    private Integer currentBearing = 2;

    Worm(Point start) {
        currentPoint = start;
    }

    Point peekLeft() {
        return DIRECTIONS.get(leftFunctionIndex()).apply(getCurrentPoint());
    }

    void turnLeft() {
        currentBearing = leftFunctionIndex();
    }

    Point peekRight() {
        return DIRECTIONS.get(rightFunctionIndex()).apply(getCurrentPoint());
    }

    void turnRight() {
        currentBearing = rightFunctionIndex();
    }

    Point peekForward() {
        return DIRECTIONS.get(currentBearing).apply(getCurrentPoint());
    }

    void stepForward() {
        setCurrentPoint(DIRECTIONS.get(currentBearing).apply(getCurrentPoint()));
    }

    private final List<Function<Point, Point>> DIRECTIONS = Lists.newArrayList(
            (point) -> new Point(point.x, point.y - 1),
            (point) -> new Point(point.x - 1, point.y),
            (point) -> new Point(point.x, point.y + 1),
            (point) -> new Point(point.x + 1, point.y)
    );

    private Integer leftFunctionIndex() {
        Integer leftBearing = currentBearing - 1;
        if (leftBearing < 0) { leftBearing = DIRECTIONS.size() - 1; }
        return leftBearing;
    }

    private Integer rightFunctionIndex() {
        return (currentBearing + 1) % DIRECTIONS.size();
    }

}
