package com.app;

import com.app.data.FileData;
import com.app.model.Lists;

public class Main {
    public static void main(String[] args) {
        var filePath = "/Users/igorsarnowski/IdeaProjects/zad2-zz10-test/numbers.txt";
        var map = FileData.getNumbers(filePath);
        var lists = new Lists(map);
//        System.out.println(lists.isFilePerfect());
//        System.out.println(lists.elemThatAreDivByDiff());
        lists.getLongestAscendingSequence();
        System.out.println(lists.checkIndexForMaxDifference());
        System.out.println(lists.checkIndexForMinDifference());
    }
}