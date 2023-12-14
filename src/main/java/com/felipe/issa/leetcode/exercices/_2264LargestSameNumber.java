package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _2264LargestSameNumber {

    public String largestGoodInteger(String num) {
        int length = num.length();
        int maxNumber = -1;
        int currentCount = 1;
        String response = "";

        for (int i = 1; i < length; i++) {
            char currentNumber = num.charAt(i);

            if (num.charAt(i - 1) == currentNumber) {
                currentCount++;
                if (currentCount == 3) {
                    if (currentNumber > maxNumber) {
                        maxNumber = currentNumber;
                        response = num.substring(i - 2, i + 1);
                    }
                }
                continue;
            }
            currentCount = 1;
        }

        return response;
    }

    @Test
    public void firstCase() {
        String output = new _2264LargestSameNumber().largestGoodInteger("6777133339");
        assertEquals("777", output);
    }

    @Test
    public void secondCase() {
        String output = new _2264LargestSameNumber().largestGoodInteger("2300019");
        assertEquals("000", output);
    }

    @Test
    public void thirdCase() {
        String output = new _2264LargestSameNumber().largestGoodInteger("42352338");
        assertEquals("", output);
    }

}
