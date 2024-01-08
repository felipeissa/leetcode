package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class _2870MininumOperationEmpty {

    public int minOperations(int[] nums) {
        Map<Integer, Integer> numberCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numberCount.put(nums[i], numberCount.getOrDefault(nums[i], 0) + 1);
        }

        int operations = 0;

        for(Integer count: numberCount.values()) {
            if(count == 1) return -1;
            operations += Math.ceil( (double)count / 3);
        }

        return operations;
    }
    public int minOperationsMine(int[] nums) {
        Map<Integer, Integer> numberCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numberCount.put(nums[i], numberCount.getOrDefault(nums[i], 0) + 1);
        }

        int operations = 0;

        for(Integer count: numberCount.values()) {
            if(count / 3 > 0) {
                int currentOperations = count / 3;
                int mod = count % 3;

                if(mod == 1) {
                    if((mod + 3) % 2 == 0) {
                       operations += currentOperations - 1;
                       count = mod + 3;
                    }
                    else return -1;
                } else {
                    operations += currentOperations;
                    count = mod;
                }

            }

            if(count / 2 > 0) {
                operations += count / 2;
                count = count % 2;
            }

            if(count != 0) return -1;
        }

        return operations;
    }

    @Test
    public void firstCase() {
        int output = new _2870MininumOperationEmpty().minOperations(ArrayParser.parse("[2,3,3,2,2,4,2,3,4]"));
        assertEquals(4, output);
    }

    @Test
    public void secondCase() {
        int output = new _2870MininumOperationEmpty().minOperations(ArrayParser.parse("[2,1,2,2,3,3]"));
        assertEquals(-1, output);
    }

    @Test
    public void test373() {
        int output = new _2870MininumOperationEmpty().minOperations(ArrayParser.parse("[14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12]"));
        assertEquals(7, output);
    }
}
