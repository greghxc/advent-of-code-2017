package org.hacksy.day24;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

class Component {
    private List<Integer> ports;
    private List<Integer> usedPorts;

    Component(Integer... ports) {
        this.ports = Lists.newArrayList(ports);
        this.usedPorts = Lists.newArrayList();
    }

    Component(List<Integer> ports) {
        this.ports = ports;
        this.usedPorts = Lists.newArrayList();
    }

    Component(List<Integer> ports, List<Integer> usedPorts) {
        this.ports = ports;
        this.usedPorts = usedPorts;
    }

    Boolean hasPort(Integer port) {
        return availablePorts().contains(port);
    }

    Component usePort(Integer port) {
        List<Integer> newUsedPorts = Lists.newArrayList(usedPorts);
        newUsedPorts.add(port);
        return new Component(ports, newUsedPorts);
    }

    Integer getStrength() {
        return ports.stream().mapToInt(port -> port).sum();
    }

    List<Integer> availablePorts() {
        List<Integer> availablePorts = Lists.newArrayList(ports);
        for (Integer port : usedPorts) {
            availablePorts.remove(port);
        }
        return availablePorts;
    }

    public String toString() {
        return ports.stream().map(i -> i.toString()).collect(Collectors.joining("|"));
    }
}
