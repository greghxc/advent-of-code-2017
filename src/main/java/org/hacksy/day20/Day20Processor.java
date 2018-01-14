package org.hacksy.day20;

import org.hacksy.util.FileUtil;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Day20Processor {
    Integer partOne(File file) {
        List<Long> lowest = FileUtil.fileToStringList(file).stream()
                .map(this::particleFrom)
                .map((particle) -> {
                    for(int i = 0; i < 10000; i++) {
                        particle.tick();
                    }
                    return particle.distance();
                })
                .collect(Collectors.toList());
        return lowest.indexOf(Collections.min(lowest));
    }

    Integer partTwo(File file) {
        List<Particle> particles = FileUtil.fileToStringList(file).stream()
                .map(this::particleFrom)
                .collect(Collectors.toList());
        for(int i = 0; i < 1000; i++) {
            Map<String, List<Particle>> posMap = new HashMap<>();

            for(Particle particle : particles) {
                particle.tick();

                List<Particle> particleList = posMap.getOrDefault(particle.getP().toString(), new ArrayList<>());
                particleList.add(particle);
                posMap.put(particle.getP().toString(), particleList);
            }

            for (String key : posMap.keySet()) {
                if (posMap.get(key).size() > 1) {
                    particles.removeAll(posMap.get(key));
                }
            }
        }
        return particles.size();
    }

    Particle particleFrom(String string) {
        List<Integer> parts = Arrays.stream(Arrays.copyOfRange(string.split("[a-z\\s,=<>]+"), 1, 10))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        return new Particle(
                new Position(parts.get(0).longValue(), parts.get(1).longValue(), parts.get(2).longValue()),
                new Position(parts.get(3).longValue(), parts.get(4).longValue(), parts.get(5).longValue()),
                new Position(parts.get(6).longValue(), parts.get(7).longValue(), parts.get(8).longValue())
        );
    }
}
