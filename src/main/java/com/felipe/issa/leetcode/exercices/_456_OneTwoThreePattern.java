package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _456_OneTwoThreePattern {

    public boolean find132pattern(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int number = nums[i];
            min = Math.min(min, number);
            max = Math.max(max, number);

            List<Integer> currentValuePositions = map.getOrDefault(number, new ArrayList<>());
            currentValuePositions.add(i);
            map.put(number, currentValuePositions);
        }

        System.out.println(MessageFormat.format("Min: {0}, max: {1}", min, max));

        return false;
    }
    public boolean find132patternBruteForce(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] < nums[k] && nums[k] < nums[j]) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean result = new _456_OneTwoThreePattern().find132pattern(new int[]{ 1,2,3,4 });
        System.out.println(MessageFormat.format("Result is: {0}, expected {1}.", result, false));

        result = new _456_OneTwoThreePattern().find132pattern(new int[]{ 3, 1, 4, 2 });
        System.out.println(MessageFormat.format("Result is: {0}, expected {1}.", result, true));

        result = new _456_OneTwoThreePattern().find132pattern(new int[]{ 3, 1, 4, 2 });
        System.out.println(MessageFormat.format("Result is: {0}, expected {1}.", result, true));
    }
}
