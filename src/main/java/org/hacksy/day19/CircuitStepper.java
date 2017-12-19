package org.hacksy.day19;

import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;
import org.hacksy.util.FileUtil;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CircuitStepper {
    private final List<Function<Point, Point>> DIRECTIONS = Lists.newArrayList(
            (point) -> new Point(point.x, point.y - 1),
            (point) -> new Point(point.x - 1, point.y),
            (point) -> new Point(point.x, point.y + 1),
            (point) -> new Point(point.x + 1, point.y)
    );

    private final List<String> VALID_FWD_CHAR = Lists.newArrayList("|", "-", "|", "-");

    private List<List<String>> grid;
    private Integer currentBearing;

    List<String> collected = new ArrayList<>();
    List<Point> locations = new ArrayList<>();

    CircuitStepper(File file) {
        currentBearing = 0;
        grid = FileUtil.fileToStringList(file).stream()
                .map((str) -> Chars.asList(str.toCharArray()).stream()
                        .map(String::valueOf).collect(Collectors.toList()))
                .collect(Collectors.toList());
        setCurrentPoint(new Point(grid.get(0).indexOf("|"), 0));
    }

    private Integer leftFunctionIndex() {
        Integer leftBearing = currentBearing - 1;
        if (leftBearing < 0) { leftBearing = DIRECTIONS.size() - 1; }
        return leftBearing;
    }

    private Integer rightFunctionIndex() {
        return (currentBearing + 1) % DIRECTIONS.size();
    }

    private Boolean leftValid() {
        Point leftPoint = DIRECTIONS.get(leftFunctionIndex()).apply(getCurrentPoint());
        String leftVal = valOf(leftPoint);
        return leftVal.equals(VALID_FWD_CHAR.get(leftFunctionIndex())) || leftVal.matches("[A-Z]");
    }

    private void turnLeft() {
        currentBearing = leftFunctionIndex();
    }

    private void turnRight() {
        currentBearing = rightFunctionIndex();
    }

    Boolean stepForward() {
        try {
            String currentVal = valOf(getCurrentPoint());
            if (currentVal.matches(" ")) {
                return false;
            }
            if (currentVal.matches("[A-Z]")) {
                collected.add(currentVal);
            }
            if (currentVal.equals("+")) {
                currentBearing = leftValid() ? leftFunctionIndex() : rightFunctionIndex();
            }
            setCurrentPoint(DIRECTIONS.get(currentBearing).apply(getCurrentPoint()));
            return getCurrentPoint().x < 0 || getCurrentPoint().y < 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private String valOf(Point point) {
        try {
            return grid.get(point.y * -1).get(point.x);
        } catch (IndexOutOfBoundsException e) {
            return " ";
        }
    }

    private Point getCurrentPoint(){
        try {
            return locations.get(locations.size() - 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            return  null;
        }
    }

    private void setCurrentPoint(Point point) {
        locations.add(point);
    }
}
