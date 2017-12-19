package org.hacksy.day19;

import java.io.File;

public class Day19Processor {
    String partOne(File file) {
        CircuitStepper stepper = new CircuitStepper(file);
        Boolean lastResult = true;

        while (lastResult) {
            lastResult = stepper.stepForward();
        }

        return stepper.collected.stream().reduce("", (a, b) -> a + b);
    }

    Integer partTwo(File file) {
        CircuitStepper stepper = new CircuitStepper(file);
        Boolean lastResult = true;

        while (lastResult) {
            lastResult = stepper.stepForward();
        }

        return stepper.locations.size() - 1;
    }
}
