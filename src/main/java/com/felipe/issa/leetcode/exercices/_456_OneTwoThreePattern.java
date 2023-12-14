package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class _456_OneTwoThreePattern {

    /**
     * https://leetcode.com/problems/132-pattern/
     */
    public boolean find132pattern(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            min = Math.min(min, number);
            max = Math.max(max, number);

            List<Integer> currentValuePositions = map.getOrDefault(number, new ArrayList<>());
            currentValuePositions.add(i);
            map.put(number, currentValuePositions);
        }

        return false;
    }

    public boolean find132patternBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
                }
            }
        }

        return false;
    }

    @Test
    public void firstCase() {
        boolean output = new _456_OneTwoThreePattern().find132patternBruteForce(new int[]{1, 2, 3, 4});
        ;
        assertEquals(false, output);
    }

    @Test
    public void secondCase() {
        boolean output = new _456_OneTwoThreePattern().find132patternBruteForce(new int[]{3, 1, 4, 2});
        assertEquals(true, output);
    }

    @Test
    public void thirdCase() {
        boolean output = new _456_OneTwoThreePattern().find132patternBruteForce(new int[]{3, 1, 4, 2});
        ;
        assertEquals(true, output);
    }
}
