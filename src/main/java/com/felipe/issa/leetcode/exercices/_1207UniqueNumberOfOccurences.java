package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class _1207UniqueNumberOfOccurences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> db = new HashMap<>();

        for(int i: arr) {
            db.put(i, db.getOrDefault(i, 0) +1 );
        }

        List<Integer> count = db.values().stream().sorted().collect(Collectors.toList());

        for(int i = 0; i < count.size() -1; i++) {
            if(count.get(i) == count.get(i+1)) return false;
        }

        return true;
    }

    @Test
    public void firstCase() {
        boolean output = new _1207UniqueNumberOfOccurences().uniqueOccurrences(ArrayParser.parse("[1,2,2,1,1,3]"));
        assertEquals(true, output);
    }

    @Test
    public void secondCase() {
        boolean output = new _1207UniqueNumberOfOccurences().uniqueOccurrences(ArrayParser.parse("[1,2,2,1,1,3]"));
        assertEquals(true, output);
    }
    @Test
    public void thirdCase() {
        boolean output = new _1207UniqueNumberOfOccurences().uniqueOccurrences(ArrayParser.parse("[-3,0,1,-3,1,1,1,-3,10,0]"));
        assertEquals(true, output);
    }
}
