package com.ebees.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

public class RandomNumberGenerator {
    public static void main(String args[]) {

        Map<Integer, List<Integer>> numberMap = readFromFile();
        
        System.out.println(numberMap);
        
        // List<Map<OptionalInt, List<Integer>>> numberMap = Lists.newArrayList();
        // generateRandomList(numberMap);
        // printNumbers(numberMap);
    }

    private static void generateRandomList(List<Map<OptionalInt, List<Integer>>> numberMap) {
        IntStream.range(0, 6).forEach(a -> {
            OptionalInt bonus = new Random().ints(1, 10).limit(1).findFirst();
            Map<OptionalInt, List<Integer>> map = Maps.newHashMap();
            map.put(bonus, generateNumberList());
            numberMap.add(map);
        });
    }
    
    private static  Map<Integer, List<Integer>> readFromFile() { 
        String fileName = "numbers.txt";
        Map<Integer, List<Integer>> numbersMap = Maps.newHashMap();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String[]> stringList = stream.map(a -> a.split(",")).collect(Collectors.toList());
            System.out.println(">>>>>>>>>>>>>>>>>"+stringList.size());
            for (String[] strings : stringList) {
                List<Integer> numbers = Arrays.stream(Stream.of(strings).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors
                    .toList());
                System.out.println("***********"+numbers.size());
                numbersMap.put(numbers.get(numbers.size()-1), numbers.stream().limit(6).collect(Collectors.toList()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbersMap;
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
