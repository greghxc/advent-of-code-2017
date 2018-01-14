package org.hacksy.day24;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.hacksy.util.FileUtil;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Bridge {
    @Getter final List<Component> connectedComponents;
    @Getter final List<Component> availableComponents;
    @Getter final Integer openPort;

    Bridge(List<Component> connectedComponents, List<Component> availableComponents) {
        this.connectedComponents = connectedComponents;
        this.availableComponents = availableComponents;
        Component lastComponentInBridge = connectedComponents.get(connectedComponents.size() - 1);
        if (lastComponentInBridge.availablePorts().size() == 1) {
            openPort = lastComponentInBridge.availablePorts().get(0);
        } else {
            System.out.println(connectedComponents.stream().map(Component::toString).collect(Collectors.joining("->")));
            throw new RuntimeException("Bridge is invalid");
        }
    }

    static Bridge fromFile(File file) {
        List<Component> components = FileUtil.fileToStringList(file).stream()
                .map(line -> Arrays.stream(line.split("/"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .map(Component::new)
                .collect(Collectors.toList());

        return new Bridge(Lists.newArrayList(new Component(0,0).usePort(0)), components);
    }

    Integer getStrength() {
        return connectedComponents.stream().mapToInt(Component::getStrength).sum();
    }

    Integer getLength() {
        return connectedComponents.size() - 1;
    }

    public String toString() {
        return connectedComponents.stream()
                .map(Component::toString)
                .collect(Collectors.joining(" -> "));
    }
}