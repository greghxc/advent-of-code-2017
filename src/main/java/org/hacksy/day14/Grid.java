package org.hacksy.day14;

import lombok.Data;
import org.hacksy.day12.QuickFind;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    private final Integer base;
    private Boolean[] isOnArray;
    private QuickFind quickFind;

    Grid(Integer base) {
        this.base = base;
        isOnArray = new Boolean[base * base];
        quickFind = new QuickFind(base * base);
    }

    Boolean getIsOn(Coord coord) {
        if (coord.getColumn() < 0 || coord.getRow() < 0) { return false; }
        if (isOnArray[coordsToIndex(coord)] == null) {
            return false;
        } else {
            return isOnArray[coordsToIndex(coord)];
        }
    }

    void turnOn(Coord coord) {
        Grid.Coord above = coord(coord.getRow() - 1, coord.getColumn());
        Grid.Coord left = coord(coord.getRow(), coord.getColumn() - 1);

        setIsOn(coord, true);

        if (getIsOn(above)) {
            connect(coord, above);
        }
        if (getIsOn(left)) {
            connect(coord, left);
        }
    }

    void connect(Coord coord1, Coord coord2) {
        quickFind.connect(coordsToIndex(coord1), coordsToIndex(coord2));
    }

    void setIsOn(Coord coord, Boolean isOn) {
        isOnArray[coordsToIndex(coord)] = isOn;
    }

    Coord coord(Integer row, Integer column) {
        return new Coord(row, column);
    }

    Integer regions() {
        Set<Integer> roots = new HashSet<>();
        for(int i = 0; i < isOnArray.length; i++) {
            if (isOnArray[i] != null && isOnArray[i]) {
                roots.add(quickFind.getRoot(i));
            }
        }
        return roots.size();
    }

    private Integer coordsToIndex(Coord coord){
        return coord.getRow() * base + coord.getColumn();
    }


    @Data
    class Coord {
        final Integer row;
        final Integer column;
    }
}
