package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;

public class _1814CountNicePairs {

    /*
     * https://leetcode.com/problems/count-nice-pairs-in-an-array/
     */


    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int reverseNumbers = 0;

        for(int i = 0; i < nums.length; i++) {
            int reversed = reverse(nums[i]);
            int value = nums[i] - reversed;
            int previousOccurrences = map.getOrDefault(value, 0);
            reverseNumbers = (reverseNumbers + previousOccurrences) % 1000000007;
            map.put(value, previousOccurrences+1);
        }

        return reverseNumbers ;
    }

    public int countNicePairsBruteForce(int[] nums) {
        int[] reversedNumbers = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            reversedNumbers[i] = reverse(nums[i]);
        }

        int reverseNumbers = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] - reversedNumbers[i] == nums[j] - reversedNumbers[j]) {
                    reverseNumbers++;
                }
            }
        }

        return reverseNumbers;
    }

    public int reverse(int number) {
        int reverse = 0;
        int lastDigit = 0;
        while (number >= 1)
        {
            lastDigit = number % 10; // gives the last digit of the number
            reverse = reverse * 10 + lastDigit;
            number = number / 10; // removes the last digit of the number
        }

        return reverse;
    }

    public static void main(String[] args) {
            int output = new _1814CountNicePairs().countNicePairs(new int[]{42, 11, 1, 97});
            System.out.println("Returned: " + output + ", should return: 2");
        output = new _1814CountNicePairs().countNicePairs(new int[]{ 13, 10, 35, 24, 76});
        System.out.println("Returned: " + output + ", should return: 4");
        output = new _1814CountNicePairs().countNicePairs(new int[]{ 9,4,0,5,2,1 });
        System.out.println("Returned: " + output + ", should return: 15");
        output = new _1814CountNicePairs().countNicePairs(new int[]{ 0,0,0,0,0,0 });
        System.out.println("Returned: " + output + ", should return: 15");
    }
}
