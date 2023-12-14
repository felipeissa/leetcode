package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class _1464MaximumProduct {

    public int maxProduct(int[] nums) {
        int indexOne, indexTwo;
        if(nums[0] >= nums[1]) {
            indexOne = 0;
            indexTwo = 1;
        } else {
            indexOne = 1;
            indexTwo = 0;
        }

        for(int i = 2; i < nums.length; i++) {
            if(nums[i] > nums[indexOne]) {
                if(nums[indexOne] > nums[indexTwo])
                    indexTwo = indexOne;
                indexOne = i;
            }
            else if (nums[i] > nums[indexTwo]) {
                indexTwo = i;
            }
        }

        return (nums[indexOne] - 1) * (nums[indexTwo] - 1);
    }

    @Test
    public void caseOne() {
        int output = new _1464MaximumProduct().maxProduct(new int[] { 3,4,5,2 });
        assertEquals(12, output);
    }

    @Test
    public void caseTwo() {
        int output = new _1464MaximumProduct().maxProduct(new int[] { 1,5,4,5 });
        assertEquals(16, output);
    }

    @Test
    public void caseThree() {
        int output = new _1464MaximumProduct().maxProduct(new int[] { 3,7});
        assertEquals(12, output);
    }
    @Test
    public void caseError() {
        int output = new _1464MaximumProduct().maxProduct(new int[] { 2,2,1,8,1,5,4,5,2,10,3,6,5,2,3});
        assertEquals(63, output);
    }

    @Test
    public void caseError2() {
        int output = new _1464MaximumProduct().maxProduct(new int[] { 8,8,7,4,2,8,1,7,7 });
        assertEquals(49, output);
    }
}
