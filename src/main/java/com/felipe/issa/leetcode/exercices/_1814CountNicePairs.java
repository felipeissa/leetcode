package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class _1814CountNicePairs {

    /*
     * https://leetcode.com/problems/count-nice-pairs-in-an-array/
     */


    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int reverseNumbers = 0;

        for (int i = 0; i < nums.length; i++) {
            int reversed = reverse(nums[i]);
            int value = nums[i] - reversed;
            int previousOccurrences = map.getOrDefault(value, 0);
            reverseNumbers = (reverseNumbers + previousOccurrences) % 1000000007;
            map.put(value, previousOccurrences + 1);
        }

        return reverseNumbers;
    }

    public int countNicePairsBruteForce(int[] nums) {
        int[] reversedNumbers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reversedNumbers[i] = reverse(nums[i]);
        }

        int reverseNumbers = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] - reversedNumbers[i] == nums[j] - reversedNumbers[j]) {
                    reverseNumbers++;
                }
            }
        }

        return reverseNumbers;
    }

    public int reverse(int number) {
        int reverse = 0;
        int lastDigit = 0;
        while (number >= 1) {
            lastDigit = number % 10; // gives the last digit of the number
            reverse = reverse * 10 + lastDigit;
            number = number / 10; // removes the last digit of the number
        }

        return reverse;
    }

    @Test
    public void firstCase() {
        int output = new _1814CountNicePairs().countNicePairs(new int[]{42, 11, 1, 97});
        assertEquals(2, output);
    }

    @Test
    public void secondCase() {
        int output = new _1814CountNicePairs().countNicePairs(new int[]{13, 10, 35, 24, 76});
        ;
        assertEquals(4, output);
    }

    @Test
    public void thirdCase() {
        int output = new _1814CountNicePairs().countNicePairs(new int[]{9, 4, 0, 5, 2, 1});
        assertEquals(15, output);
    }

    @Test
    public void forthCase() {
        int output = new _1814CountNicePairs().countNicePairs(new int[]{0, 0, 0, 0, 0, 0});
        assertEquals(15, output);
    }
}
