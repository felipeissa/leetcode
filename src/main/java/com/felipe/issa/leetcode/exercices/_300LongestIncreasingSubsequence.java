package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _300LongestIncreasingSubsequence {

    private int[] nums;
    int[][] dp;

    int n;

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = Arrays.stream(dp).max().getAsInt();
        return maxLen;
    }

    public int lengthOfLISTD(int[] nums) {
        this.nums = nums;
        this.dp =  new int[nums.length][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, -1);
    }

    public int solve(int currentIndex, int previousIndex) {
        if(currentIndex == nums.length ) return 0;
        if (dp[currentIndex][previousIndex + 1] != -1) return dp[currentIndex][previousIndex + 1];
        int len = solve(currentIndex+1, previousIndex);
        if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
            len = Math.max(len, solve(currentIndex+1, currentIndex) +1);
        }
        return dp[currentIndex][previousIndex+1] = len;
    }

    @Test
    public void myCase1() {
        int output = new _300LongestIncreasingSubsequence().lengthOfLIS(ArrayParser.parse("[1,2,3]"));
        assertEquals(3, output);
    }

    @Test
    public void firstCase() {
        int output = new _300LongestIncreasingSubsequence().lengthOfLIS(ArrayParser.parse("[10,9,2,5,3,7,101,18]"));
        assertEquals(4, output);
    }

    @Test
    public void secondCase() {
        int output = new _300LongestIncreasingSubsequence().lengthOfLIS(ArrayParser.parse("[0,1,0,3,2,3]"));
        assertEquals(4, output);
    }

    @Test
    public void thirdCase() {
        int output = new _300LongestIncreasingSubsequence().lengthOfLIS(ArrayParser.parse("[7,7,7,7,7,7,7]"));
        assertEquals(1, output);
    }

    @Test
    public void test15() {
        int output = new _300LongestIncreasingSubsequence().lengthOfLIS(ArrayParser.parse("[-2,-1]"));
        assertEquals(2, output);
    }

    @Test
    public void test17() {
        int output = new _300LongestIncreasingSubsequence().lengthOfLIS(ArrayParser.parse("[4,10,4,3,8,9]"));
        assertEquals(3, output);
    }

    @Test
    public void testWith31() {
        int output = new _300LongestIncreasingSubsequence().lengthOfLIS(ArrayParser.parse("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32"));
        assertEquals(31, output);
    }
}
