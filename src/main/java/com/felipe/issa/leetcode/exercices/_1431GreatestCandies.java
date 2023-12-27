package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class _1431GreatestCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i: candies) {
            max = Math.max(i, max);
        }

        max -= extraCandies;
        List<Boolean> output = new LinkedList<>();
        for(int i: candies) {
            output.add(i >= max);
        }
        return output;
    }

    @Test
    public void firstCase() {
        List<Boolean> output = new _1431GreatestCandies().kidsWithCandies(ArrayParser.parse("[2,3,5,1,3]"), 3);
        assertEquals(Arrays.asList(true,true,true,false,true), output);
    }
    @Test
    public void secondCase() {
        List<Boolean> output = new _1431GreatestCandies().kidsWithCandies(ArrayParser.parse("[4,2,1,1,2]"), 1);
        assertEquals(Arrays.asList(true,false,false,false,false), output);
    }
    @Test
    public void thirdCase() {
        List<Boolean> output = new _1431GreatestCandies().kidsWithCandies(ArrayParser.parse("[12,1,12]"), 10);
        assertEquals(Arrays.asList(true,false,true), output);
    }
}
