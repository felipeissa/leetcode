package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _70ClimbingStairs {

    int[] db;
    public int climbStairs(int n) {
        db = new int[n+1];

        return solve(0, n);
    }

    private int solve(int current, int target) {
        if(current == target) return 1;
        if(db[current] > 0) return db[current];

        int ways = solve(current + 1, target);

        if(current + 2 <= target) {
            ways += solve(current + 2, target);
        }

        db[current] = ways;
        return ways;
    }

    @Test
    public void firstCase() {
        int output = new _70ClimbingStairs().climbStairs(2);
        assertEquals(2, output);
    }

    @Test
    public void secondCase() {
        int output = new _70ClimbingStairs().climbStairs(3);
        assertEquals(3, output);
    }

    @Test
    public void test3() {
        int output = new _70ClimbingStairs().climbStairs(5);
        assertEquals(5, output);
    }

}
