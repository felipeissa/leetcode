package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;

public class _191NumberOf1Bits {

    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i < binary.length(); i++) {
            if(49 == binary.charAt(i)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int output;
        int expected;

        output = new _191NumberOf1Bits().hammingWeight(11);
        expected = 3;
        System.out.println(MessageFormat.format("Same: {0}. Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _191NumberOf1Bits().hammingWeight(128);
        expected = 1;
        System.out.println(MessageFormat.format("Same: {0}. Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _191NumberOf1Bits().hammingWeight(-3);
        expected = 31;
        System.out.println(MessageFormat.format("Same: {0}. Expected: {1}, got: {2}", output == expected, expected, output));
    }
}
