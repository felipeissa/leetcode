package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int initialPosition = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                nums[initialPosition++] = nums[i];
            }
        }
        while(initialPosition < nums.length) {
            nums[initialPosition++] = 0;
        }
    }

    @Test
    public void firstCase() {
        int[] input = ArrayParser.parse("[0,1,0,3,12]");
        new _283MoveZeroes().moveZeroes(input);
        assertArrayEquals(ArrayParser.parse("[1,3,12,0,0]"), input);
    }

    @Test
    public void secondCase() {
        int[] input = ArrayParser.parse("[0]");
        new _283MoveZeroes().moveZeroes(input);
        assertArrayEquals(ArrayParser.parse("[0]"), input);
    }

    @Test
    public void test19() {
        int[] input = ArrayParser.parse("[0]");
        new _283MoveZeroes().moveZeroes(input);
        assertArrayEquals(ArrayParser.parse("[0]"), input);
    }
}
