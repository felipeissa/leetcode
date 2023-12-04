package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;

public class _2264LargestSameNumber {

    public String largestGoodInteger(String num) {
        int length = num.length();
        int maxNumber = -1;
        int currentCount = 1;
        String response = "";

        for(int i = 1; i < length; i++) {
            char currentNumber = num.charAt(i);

            if(num.charAt(i-1)  == currentNumber) {
                currentCount ++;
                if(currentCount == 3) {
                    if(currentNumber > maxNumber) {
                        maxNumber = currentNumber;
                        response = num.substring(i-2, i+1);
                    }
                }
                continue;
            }
            currentCount = 1;
        }

        return response;
    }

    public static void main(String[] args) {
        String output;
        String expected;

        output = new _2264LargestSameNumber().largestGoodInteger("6777133339");
        expected = "777";
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", output.equals(expected), expected, output));

        output = new _2264LargestSameNumber().largestGoodInteger("2300019");
        expected = "000";
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", output.equals(expected), expected, output));

        output = new _2264LargestSameNumber().largestGoodInteger("42352338");
        expected = "";
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", output.equals(expected), expected, output));
    }
}
