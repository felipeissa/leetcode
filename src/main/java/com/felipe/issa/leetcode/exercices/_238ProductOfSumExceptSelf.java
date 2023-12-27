package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class _238ProductOfSumExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int zeroCount = 0;
        int totalValue = 1;
        for(int i = 0; i < size; i++) {
            if(nums[i] == 0) zeroCount ++;
            totalValue *= nums[i];
        }

        if(zeroCount == 0) {
            return noZeroCountResult(nums, totalValue);
        } else if (zeroCount == 1) {
            return singleZeroCountResult(nums);
        }

        return new int[size];
    }

    public int[] noZeroCountResult(int[] nums, int totalValue) {
        int [] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = totalValue / nums[i];
        }
        return result;
    }

    public int[] singleZeroCountResult(int[] nums) {
        int zeroIndex = 0;
        int totalValue = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                totalValue *= nums[i];
            } else {
                zeroIndex = i;
            }
        }

        int [] result = new int[nums.length];
        result[zeroIndex] = totalValue;

        return result;
    }

    public int[] productExceptSelfBruteForce(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            int first = i == 0 ? 1: 0;
            result[i] = nums[first];
            for(int j = first + 1; j < size; j++) {
                if(i != j) {
                    result[i] *= nums[j];
                }
            }
        }
        return result;
    }

    @Test
    public void firstCase() {
        int[] output = new _238ProductOfSumExceptSelf().productExceptSelf(ArrayParser.parse("[1,2,3,4]"));
        assertArrayEquals(ArrayParser.parse("[24,12,8,6]"), output);
    }

    @Test
    public void secondCase() {
        int[] output = new _238ProductOfSumExceptSelf().productExceptSelf(ArrayParser.parse("[-1,1,0,-3,3]"));
        assertArrayEquals(ArrayParser.parse("[0,0,9,0,0]"), output);
    }

    @Test
    public void myCase() {
        int[] output = new _238ProductOfSumExceptSelf().productExceptSelf(ArrayParser.parse("[-1,1,0,-3,3,0]"));
        assertArrayEquals(ArrayParser.parse("[0,0,0,0,0,0]"), output);
    }
}
