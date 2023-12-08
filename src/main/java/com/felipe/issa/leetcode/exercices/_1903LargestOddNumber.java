package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;

public class _1903LargestOddNumber {

    public String largestOddNumber(String num) {
        for(int i = num.length() -1 ; i >= 0; i--) {
            if(num.charAt(i) % 2 == 1) return num.substring(0, i+1);
        }

        return "";
    }

    public static void main(String[] args) {
        String output;
        String expected;

        expected = "5";
        output = new _1903LargestOddNumber().largestOddNumber("52");
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", expected.equals(output), expected, output));

        expected = "";
        output = new _1903LargestOddNumber().largestOddNumber("4206");
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", expected.equals(output), expected, output));

        expected = "35427";
        output = new _1903LargestOddNumber().largestOddNumber("35427");
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", expected.equals(output), expected, output));
    }
}
