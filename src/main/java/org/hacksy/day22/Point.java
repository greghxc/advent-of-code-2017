package org.hacksy.day22;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Point {
    final public Integer x;
    final public Integer y;

    Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
