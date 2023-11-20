package com.felipe.issa.leetcode.exercices;

import java.util.HashMap;
import java.util.Map;

public class _1TwoSum {

    /**
     * https://leetcode.com/problems/two-sum/description/
     */

    // best approach, got from discussion
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();
        for(int i = 0; i < nums.length ; i++) {
            Integer boxed = nums[i];
            Integer missingPart = target - boxed;

            if(values.containsKey(missingPart)) {
                return new int[] {i, values.get(missingPart)};
            }
            values.put(boxed, i);
        }

        return new int[] {};
    }

    // approach 2
    public int[] twoSumWithHashMap(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();
        for(int i = 0; i < nums.length ; i++) {
            Integer boxed = nums[i];
            if(!values.containsKey(boxed)) {
                values.put(boxed, i);
            } else if(boxed + boxed == target) {
                return new int[] {i, values.get(boxed)};
            }
        }

        for(Map.Entry<Integer, Integer> entry: values.entrySet()) {
            Integer missingPart = target - entry.getKey();
            if(values.containsKey(missingPart)) {
                return new int[] {entry.getValue(), values.get(missingPart)};
            }
        }

        return new int[] {};
    }

    // approach 1
    public int[] twoSumBruteForce(int[] nums, int target) {
        for(int i = 0; i < nums.length -1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target)
                    return new int[] {i, j};
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};

        int[] response = new _1TwoSum().twoSum(nums, 9);
        System.out.println(response[0] + "," + response[1]);
    }
}
