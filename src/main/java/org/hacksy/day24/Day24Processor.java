package org.hacksy.day24;

import com.google.common.collect.Lists;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day24Processor {
    Integer partOne(File file) {
        Function<List<Bridge>,Integer> analyzer =
                (bridges) -> bridges.stream()
                    .mapToInt(Bridge::getStrength)
                    .max().getAsInt();

        return processFile(file, analyzer);
    }

    Integer partTwo(File file) {
        Function<List<Bridge>, Integer> analyzer = (bridges) -> {
            Integer maxSize = bridges.stream()
                .mapToInt(Bridge::getLength)
                .max().getAsInt();

            return bridges.stream()
                    .filter(bridge -> bridge.getLength().equals(maxSize))
                    .mapToInt(Bridge::getStrength)
                    .max().getAsInt();
        };

        return processFile(file, analyzer);
    }

    private Integer processFile(File file, Function<List<Bridge>, Integer> analyzer) {
        List<Bridge> bridges = Lists.newArrayList(Bridge.fromFile(file));

        for(int i = 0; i < bridges.size(); i++) {
            bridges.addAll(processBridge(bridges.get(i)));
        }

        return analyzer.apply(bridges);
    }

    private List<Bridge> processBridge(Bridge bridge) {
        return bridge.getAvailableComponents().stream()
                .filter(component -> component.hasPort(bridge.getOpenPort()))
                .map(component -> {
                    List<Component> newConnected = new ArrayList<>();
                    newConnected.addAll(bridge.getConnectedComponents());
                    newConnected.add(component.usePort(bridge.getOpenPort()));
                    List<Component> newAvailable = new ArrayList<>();
                    newAvailable.addAll(bridge.getAvailableComponents());
                    newAvailable.remove(component);
                    return new Bridge(newConnected, newAvailable);
                })
                .collect(Collectors.toList());
    }


}
