package org.hacksy.day23;

import java.io.File;

public class Day23Processor {
    Integer partOne(File file) {
        Program program = new Program(0, file);
        while (program.executeNext()) { }
        program.printRegisters();
        return program.mulCount;
    }
}
