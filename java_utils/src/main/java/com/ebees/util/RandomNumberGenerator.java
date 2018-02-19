package com.ebees.util;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

import com.google.api.client.util.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

public class RandomNumberGenerator {
    public static void main(String args[]) {

        List<Map<OptionalInt, List<Integer>>> numberMap = Lists.newArrayList();
        IntStream.range(0, 6).forEach(a -> {
            OptionalInt bonus = new Random().ints(1, 10).limit(1).findFirst();
            Map<OptionalInt, List<Integer>> map = Maps.newHashMap();
            map.put(bonus, generateNumberList());
            numberMap.add(map);
        });
        printNumbers(numberMap);
    }

    private static void printNumbers(List<Map<OptionalInt, List<Integer>>> numbers) {
        numbers.forEach(map -> {
            for (Map.Entry<OptionalInt, List<Integer>> entry : map.entrySet()) {
                System.out.println("[" + entry.getKey().getAsInt() + "] : " + entry.getValue());
            }
        });
    }

    private static List<Integer> generateNumberList() {
        List<Integer> numberList = Ints.asList(new Random().ints(6, 1, 40).distinct().sorted().toArray());
        if (numberList.size() == 6) {
            return numberList;
        } else {
            return generateNumberList();
        }
    }
}
