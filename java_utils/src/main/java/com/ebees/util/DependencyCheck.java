package com.ebees.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class DependencyCheck {
    
    private static List<String> calculateDependency(String target, Map<String, List<String>> dataMap) {
 
        List<String> dependencies = new ArrayList<>();
 
        // Declare and implement a queue to store each of the dependencies
        Queue<String> queue = new LinkedList<>();
        // Add target into queue
        queue.add(target);
 
        while(!queue.isEmpty()) {
            // Retrieve and remove the first target from queue
            String currentTarget = queue.remove();
            // Add current target into dependencies list
            dependencies.add(currentTarget);                
            
            // Add each of the next target into queue if data map has dependencies
            if (dataMap.containsKey(currentTarget)) {
                for(String nextTarget : dataMap.get(currentTarget)) {
                    queue.add(nextTarget);
                }
            }
        }
        
        // Filter the redundancy dependencies and return the list in a reverse order    
        return dependencies.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
 
    public static void main(String[] args) {
        Map<String, List<String>> depenceyMap = new HashMap<>();
        depenceyMap.put("A", Arrays.asList("B","C"));
        depenceyMap.put("B", Arrays.asList("D"));
        depenceyMap.put("C", Arrays.asList("D"));
        depenceyMap.put("D", Collections.emptyList());
        depenceyMap.put("E", Arrays.asList("F"));
        
        String target = "D";
        List<String> finalList = calculateDependency(target, depenceyMap);
        
        System.out.println(finalList); // D, C, B, A
    }
 
}

 



 
