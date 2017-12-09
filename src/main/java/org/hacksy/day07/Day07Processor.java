package org.hacksy.day07;

import org.hacksy.util.FileUtil;
import org.hacksy.day07.ProgramStack.Program;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

class Day07Processor {
    String partOne(File file) {
        ProgramStack stack = fileToStack(file);
        return stack.getBase().getName();
    }

    Integer partTwo(File file) {
        ProgramStack stack = fileToStack(file);
        Program base = stack.getBase();

        Program violator = null;

        while (violator == null) {
            Program result = unweightedProgram(base);
            if (result == null) {
                violator = base;
            } else {
                base = result;
            }
        }
        Integer diff = violator.getSiblings().get(0).getCalculatedWeight() - violator.getCalculatedWeight();
        return violator.getWeight() + diff;
    }

    private Program unweightedProgram(Program base) {
        List<Program> children = base.getChildren();
        Integer norm = children.get(0).getCalculatedWeight().equals(children.get(1).getCalculatedWeight()) ||
                children.get(0).getCalculatedWeight().equals(children.get(2).getCalculatedWeight()) ?
                children.get(0).getCalculatedWeight() : children.get(1).getCalculatedWeight();
        for (Program child : children) {
            if (!child.getCalculatedWeight().equals(norm)) {
                return child;
            }
        }
        return null;
    }

    private List<List<String>> listToLists(List<String> lines) {
        return lines.stream().map((line) -> Arrays.asList(line.split("[\\s()\\->,]+"))).collect(Collectors.toList());
    }

    private ProgramStack fileToStack(File file) {
        ProgramStack stack = new ProgramStack();
        List<List<String>> rawPrograms = listToLists(FileUtil.fileToStringList(file));
        for (List<String> program : rawPrograms) {
            List<String> children = program.size() > 2 ? program.subList(2, program.size()) : new ArrayList<>();
            stack.addToMap(program.get(0), Integer.parseInt(program.get(1)), children);
        }
        return stack;
    }
}
