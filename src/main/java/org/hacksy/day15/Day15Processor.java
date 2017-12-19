package org.hacksy.day15;

class Day15Processor {
    Integer partOne(Integer a, Integer b) {
        Generator genA = new Generator(16807, 2147483647, (_val) -> true);
        Generator genB = new Generator(48271, 2147483647, (_val) -> true);
        return process(genA, genB, a, b, 40000000);
    }

    Integer partTwo(Integer a, Integer b) {
        Generator genA = new Generator(16807, 2147483647, (val) -> val % 4 == 0);
        Generator genB = new Generator(48271, 2147483647, (val) -> val % 8 == 0);
        return process(genA, genB, a, b, 5000000);
    }

    private Integer process(Generator genA, Generator genB, Integer startA, Integer startB, Integer iterations) {
        Integer lastA = startA;
        Integer lastB = startB;

        Integer count = 0;

        for(int i = 0; i < iterations; i++) {
            lastA = genA.generateValue(lastA);
            lastB = genB.generateValue(lastB);

            String binA = Integer.toBinaryString(lastA);
            String binB = Integer.toBinaryString(lastB);

            String compA = binA.length() > 16 ? binA.substring(binA.length() - 16) : binA;
            String compB = binB.length() > 16 ? binB.substring(binB.length() - 16) : binB;

            if (compA.equals(compB)) {
                count++;
            }
        }
        return count;
    }
}
