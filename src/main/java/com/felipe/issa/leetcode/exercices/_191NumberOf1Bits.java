package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _191NumberOf1Bits {

    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (49 == binary.charAt(i)) count++;
        }

        return count;
    }

    @Test
    public void firstCase() {
        int output = new _191NumberOf1Bits().hammingWeight(11);
        ;
        assertEquals(3, output);
    }

    @Test
    public void secondCase() {
        int output = new _191NumberOf1Bits().hammingWeight(128);
        ;
        assertEquals(1, output);
    }

    @Test
    public void thirdCase() {
        int output = new _191NumberOf1Bits().hammingWeight(-3);
        assertEquals(31, output);
    }
}
