package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _1913MaximumProduct {

    public int maxProductDifference(int[] nums) {
        int biggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;

        for(int number: nums) {
            if(number > biggest) {
                if(biggest > secondBiggest) {
                    secondBiggest = biggest;
                }
                biggest = number;
            } else if(number > secondBiggest) {
                secondBiggest = number;
            }
            if(number < lowest) {
                if(lowest < secondLowest) {
                    secondLowest = lowest;
                }
                lowest = number;
            }
            else if(number < secondLowest) {
                secondLowest = number;
            }
        }

        return (biggest * secondBiggest) - (lowest * secondLowest);
    }

    public int maxProductDifferenceWithSort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        return (nums[length - 1] * nums[length -2]) - (nums[0] * nums[1]);
    }

    @Test
    public void firstCase() {
        int output = new _1913MaximumProduct().maxProductDifference(ArrayParser.parse("[5,6,2,7,4]"));
        assertEquals(34, output);
    }

    @Test
    public void secondCase() {
        int output = new _1913MaximumProduct().maxProductDifference(ArrayParser.parse("[4,2,5,9,7,4,8]"));
        assertEquals(64, output);
    }
}
