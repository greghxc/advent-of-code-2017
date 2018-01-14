package org.hacksy.day20;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
class Position {
    @Getter @Setter Long x;
    @Getter @Setter Long y;
    @Getter @Setter Long z;

    Long distance() {
        return Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    public String toString() {
        return String.format("<%s,%s,%s>", x, y, z);
    }
}