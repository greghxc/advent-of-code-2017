package org.hacksy.day10;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.primitives.Chars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day10Processor {
    Integer partOne(List<Integer> ribbon, List<Integer> jumps) {
        ribbon = ribbonProc(ribbon, jumps, 1);
        return ribbon.get(0) * ribbon.get(1);
    }

    public String partTwo(String input) {
        List<Integer> ribbon =
                ribbonProc(buildRibbon(256), prepareInput(input, Lists.newArrayList(17, 31, 73, 47, 23)), 64);
        return hash(Lists.partition(ribbon, 16).stream()
                .map(this::compressBlock)
                .collect(Collectors.toList()));
    }

    private List<Integer> ribbonProc(List<Integer> ribbon,  List<Integer> jumps, Integer iterations) {
        Integer currentPosition = 0;
        Integer persistentSkip = 0;

        for (int i = 0; i < iterations; i ++) {
            // Refactor this jumble? I roll list forward to current position, leverage Collections.reverse on a subset,
            // reassemble, then roll back. I toyed with keep track of how far I'd rolled forward to keep track of
            // original start, but that seemed like optimizing the wrong part. For now, this is easily inspectable at
            // every step.
            for (int jump : jumps) {
                ribbon = listRoller(ribbon, currentPosition);

                List<Integer> modifiedList = Lists.newArrayList(ribbon.subList(0, jump));
                List<Integer> remainingList = jump < ribbon.size() ? Lists.newArrayList(ribbon.subList(jump, ribbon.size())) : Lists.newArrayList();

                Collections.reverse(modifiedList);

                List<Integer> combinedList = Lists.newArrayList();
                combinedList.addAll(modifiedList);
                combinedList.addAll(remainingList);

                ribbon = listRoller(combinedList, combinedList.size() - (currentPosition % combinedList.size()));
                currentPosition += persistentSkip + jump;

                persistentSkip++;
            }
        }
        return ribbon;
    }


    <T> List<T> listRoller(List<T> list, Integer rollTo) {
        List<T> newEnd = Lists.newArrayList(list.subList(0, rollTo % list.size()));
        List<T> newBeginning = Lists.newArrayList(list.subList(rollTo % list.size(), list.size()));
        List<T> rolledList = Lists.newArrayList(newBeginning);
        rolledList.addAll(newEnd);
        return rolledList;
    }

    List<Integer> prepareInput(String input, List<Integer> salt) {
        List<Integer> blandList = Chars.asList(input.toCharArray()).stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        blandList.addAll(salt);
        return blandList;
    }

    Integer compressBlock(List<Integer> block) {
        return block.stream().reduce(0, (a, b) -> a ^ b);
    }

    String hash(List<Integer> integers) {
        return integers.stream()
                .map((a) -> String.format("%02x", a))
                .reduce("", (a, b) -> a + b);
    }

    List<Integer> buildRibbon(Integer length) {
        return ContiguousSet.create(Range.closed(0, length - 1), DiscreteDomain.integers()).asList();
    }
}