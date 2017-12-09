package org.hacksy.day07;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class ProgramStack {
    @AllArgsConstructor
    class Program {
        @Getter private String name;
        @Getter private Integer weight;
        private ProgramStack programStack;

        Integer getCalculatedWeight() {
            return programStack.getCalculatedWeight(name);
        }

        List<Program> getChildren() {
            return programStack.getChildren(name);
        }

        Program getParent() {
            return programStack.nameToProgram.get(programStack.programToParent.get(name));
        }

        List<Program> getSiblings(){
            List<Program> siblings = getParent().getChildren();
            siblings.remove(this);
            return siblings;
        }
    }

    private Map<String, Program> nameToProgram = new HashMap<>();
    private Map<String, String> programToParent  = new HashMap<>();
    private Map<String, List<String>> programToChildren = new HashMap<>();

    Program addToMap(String name, Integer weight, List<String> children) {
        Program program = new Program(name, weight, this);
        addChildren(name, children);
        nameToProgram.put(name, program);
        return program;
    }

    Program getProgram(String name) {
        return nameToProgram.get(name);
    }

    Program getBase(){
        Set<String> set = new HashSet<>(nameToProgram.keySet());
        set.removeAll(programToParent.keySet());
        return nameToProgram.get(set.iterator().next());
    }

    private void addChildren(String parentName, List<String> children) {
        programToChildren.put(parentName, children);
        for (String childName : children) {
            programToParent.put(childName, parentName);
        }
    }

    private Integer getCalculatedWeight(String name) {
        List<String> programNames = Lists.newArrayList(name);
        Integer acc = 0;
        for (int i = 0; i < programNames.size(); i++) {
            Program program = nameToProgram.get(programNames.get(i));
            acc += program.weight;
            programNames.addAll(programToChildren.get(program.getName()));
        }
        return acc;
    }

    private List<Program> getChildren(String name) {
        return programToChildren.get(name).stream()
                .map((childName) -> nameToProgram.get(childName))
                .collect(Collectors.toList());
    }
}
