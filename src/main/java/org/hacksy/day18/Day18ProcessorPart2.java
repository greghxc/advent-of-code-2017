package org.hacksy.day18;

import com.google.common.collect.Lists;

import java.io.File;
import java.util.List;

public class Day18ProcessorPart2 {
    Integer partTwo(File file) {
        Queue program0Output = new Queue();
        Queue program1Output = new Queue();

        Program program0 = new Program(0, program0Output, program1Output, file);
        Program program1 = new Program(1, program1Output, program0Output, file);

        List<Program> programs = Lists.newArrayList(program0, program1);

        while (program0.executeNext() || program1.executeNext()) { }

        return program1.sendCount;
    }
}
