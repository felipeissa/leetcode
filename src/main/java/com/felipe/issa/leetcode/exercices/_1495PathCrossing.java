package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.Pair;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class _1495PathCrossing {

    public boolean isPathCrossing(String path) {

        Pair<Integer, Integer> point = new Pair<>(0, 0);
        Set<Pair<Integer, Integer>> previousPoints = new HashSet<>();
        previousPoints.add(point);

        for(int i = 0; i < path.length(); i++) {

            char next = path.charAt(i);
            if(next == 'N') point = new Pair<>(point.getKey() + 1, point.getValue());
            else if(next == 'S') point = new Pair<>(point.getKey() - 1, point.getValue());
            else if(next == 'E') point = new Pair<>(point.getKey(), point.getValue() + 1);
            else if(next == 'W') point = new Pair<>(point.getKey(), point.getValue() - 1);

            if(!previousPoints.add(point)) return true;
        }

        return false;
    }

    @Test
    public void firstCase() {
        boolean crossed = new _1495PathCrossing().isPathCrossing("NES");
        assertEquals(false, crossed);
    }

    @Test
    public void secondCase() {
        boolean crossed = new _1495PathCrossing().isPathCrossing("NESWW");
        assertEquals(true, crossed);
    }
}
