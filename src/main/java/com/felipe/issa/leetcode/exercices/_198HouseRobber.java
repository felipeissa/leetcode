package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _198HouseRobber {


    int[] houses;
    int[] history;
    public int rob(int[] nums) {
        houses = nums;
        history = new int[nums.length];
        Arrays.fill(history, -1);
        return solve(0);
    }

    private int solve(int index) {
        if(index >= houses.length) return 0;
        if(index == houses.length -1 ) return houses[index];
        if(history[index] >= 0) return history[index];

        int skippingCurrent = solve(index + 1);
        int withCurrent = solve(index +2) + houses[index];

        return history[index] = Math.max(skippingCurrent, withCurrent);
    }

    @Test
    public void firstCase() {
        int output = new _198HouseRobber().rob(ArrayParser.parse("[1,2,3,1]"));
        assertEquals(4, output);
    }

    @Test
    public void second() {
        int output = new _198HouseRobber().rob(ArrayParser.parse("[2,7,9,3,1]"));
        assertEquals(12, output);
    }
}
