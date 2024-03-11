package com.app.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Lists {
    private static List<Integer> smallestInt;
    private static List<Integer> middleInt;
    private static List<Integer> biggestInt;
    private static Map<Integer, List<Integer>> map;

    public Lists(Map<Integer, List<Integer>> map) {
        Lists.map = map;
        biggestInt = getMaxFromEachLine();
        middleInt = getMidFromEachLine();
        smallestInt = getMinFromEachLine();
    }

    private static List<Integer> getMaxFromEachLine() {
        return map
                .values()
                .stream()
                .map(list -> list
                        .stream()
                        .max(Integer::compare).orElseThrow())
                .toList();
    }

    private static List<Integer> getMidFromEachLine() {
        return map
                .values()
                .stream()
                .map(line -> line.stream().sorted().toList().get(1))
                .toList();
    }

    private static List<Integer> getMinFromEachLine() {
        return map
                .values()
                .stream()
                .map(list -> list
                        .stream()
                        .min(Integer::compare).orElseThrow())
                .toList();
    }

    public boolean isFilePerfect() {
        for (int i = 0; i < biggestInt.size(); i++) {
            for (int j = 0; j < biggestInt.size(); j++) {
                if (!(smallestInt.get(j) < middleInt.get(i) && middleInt.get(i) < biggestInt.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Integer> elementThatAreDividedByDifference() {
        var elements = new ArrayList<Integer>();
        var diff = Math.abs(getBiggestValue(smallestInt) - getSmallestValue(middleInt));
        for (var num : biggestInt) {
            if (isDivided(num, diff)) {
                elements.add(num);
            }
        }
        return elements;
    }

    public void getLongestAscendingSequence() {
        var sortSmallest = sortAscending(smallestInt);
        var diff1 = sortSmallest.get(2) - sortSmallest.get(0);
        var sortMiddle = sortAscending(middleInt);
        var diff2 = sortMiddle.get(2) - sortMiddle.get(0);
        var sortBiggest = sortAscending(biggestInt);
        var diff3 = sortBiggest.get(2) - sortBiggest.get(0);
        var list = List.of(diff1, diff2, diff3);
        var max = list.stream().max(Integer::compare).orElseThrow();
        for (int i = 0; i < list.size(); i++) {
            if (max.equals(list.get(i))) {
                System.out.println(i + 1);
            }
        }
    }

    public Integer checkIndexForMinDifference() {
        return differences().stream().min(Integer::compare).orElseThrow();
    }

    public Integer checkIndexForMaxDifference() {
        return differences().stream().max(Integer::compare).orElseThrow();
    }

    private static List<Integer> differences() {
        var sortSmallest = sortDescending(smallestInt);
        var sortMiddle = sortDescending(middleInt);
        var sortBiggest = sortDescending(biggestInt);
        var differences = new ArrayList<Integer>();
        for (int i = 0; i < smallestInt.size(); i++) {
            int diff = 0;
            diff = sortBiggest.get(i) - sortMiddle.get(i) - sortSmallest.get(i);
            differences.add(diff);
        }
        return differences;
    }


    private static Integer getBiggestValue(List<Integer> values) {
        return values
                .stream()
                .max(Integer::compare)
                .orElseThrow();
    }

    private static Integer getSmallestValue(List<Integer> values) {
        return values
                .stream()
                .min(Integer::compare)
                .orElseThrow();
    }

    private static boolean isDivided(int a, int b) {
        return a % b == 0;
    }

    private static List<Integer> sortDescending(List<Integer> values) {
        return values
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    private static List<Integer> sortAscending(List<Integer> values) {
        return values
                .stream()
                .sorted()
                .toList();
    }
}
