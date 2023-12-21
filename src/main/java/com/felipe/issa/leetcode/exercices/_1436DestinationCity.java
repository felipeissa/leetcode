package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class _1436DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> cityWithNoOrigin = new HashSet<>();
        Set<String> cityWithOrigin = new HashSet<>();

        for(List<String> path: paths) {
           cityWithOrigin.add(path.get(0));
           cityWithNoOrigin.remove(path.get(0));
           if(!cityWithOrigin.contains(path.get(1))) {
               cityWithNoOrigin.add(path.get(1));
           }
        }

        return cityWithNoOrigin.iterator().next();
    }


    @Test
    public void firstCase() {
        String output = new _1436DestinationCity().destCity(Arrays.asList(
            Arrays.asList("London", "New York"),
            Arrays.asList("New York","Lima"),
            Arrays.asList("Lima","Sao Paulo")
        ));

        assertEquals("Sao Paulo", output);
    }

    @Test
    public void secondCase() {
        String output = new _1436DestinationCity().destCity(Arrays.asList(
            Arrays.asList("B","C"),
            Arrays.asList("D","B"),
            Arrays.asList("C","A")
        ));

        assertEquals("A", output);
    }

    @Test
    public void thirdCase() {
        String output = new _1436DestinationCity().destCity(Arrays.asList(
            Arrays.asList("A","Z")
        ));

        assertEquals("Z", output);
    }
}
