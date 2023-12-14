package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class _1903LargestOddNumber {

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 == 1) return num.substring(0, i + 1);
        }

        return "";
    }

    @Test
    public void firstCase() {
        String output = new _1903LargestOddNumber().largestOddNumber("4206");
        ;
        assertEquals("", output);
    }

    @Test
    public void secondCase() {
        String output = new _1903LargestOddNumber().largestOddNumber("52");
        assertEquals("5", output);
    }

    @Test
    public void thirdCase() {
        String output = new _1903LargestOddNumber().largestOddNumber("35427");
        assertEquals("35427", output);
    }
}
