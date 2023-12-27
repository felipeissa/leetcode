package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class _1071CommonDivisor {


    public String gcdOfStrings(String str1, String str2) {
        return str1.length() > str2.length() ? check(str1, str2) : check(str2, str1);
    }

    public String check(String bigger, String smaller) {
        int size = smaller.length();

        while(size > 0) {
            if(bigger.length() % size != 0 || smaller.length() % size != 0 ) {
                size--;
                continue;
            }

            int j = 0;
            for(int i = 0; i < bigger.length(); i++ ) {
                if(bigger.charAt(i) != smaller.charAt(j) || (i < smaller.length() && smaller.charAt(i) != smaller.charAt(j))) {
                    size--;
                    break;
                }

                j = j+1 >= size ? 0 : j+1;

                if(i+1 == bigger.length() && j == 0) {
                    return smaller.substring(0, size);
                }
            }
        }

        return "";
    }


    /*
        worst case scenario, array
     */
    public String checkArray(String bigger, String smaller) {
        int length = smaller.length();
        while(length > 0) {
            String[] data = bigger.split(smaller.substring(0, length));
            if(data.length != 0) {
                length--; continue;
            }
            data = smaller.split(smaller.substring(0, length));
            if(data.length == 0)
                return smaller.substring(0, length);
            length--;
        }

        return "";
    }

    @Test
    public void firstCase(){
        String output = new _1071CommonDivisor().gcdOfStrings("ABCABC", "ABC");
        assertEquals("ABC", output);
    }
    @Test
    public void secondCase(){
        String output = new _1071CommonDivisor().gcdOfStrings("ABABAB", "ABAB");
        assertEquals("AB", output);
    }

    @Test
    public void thirdCase(){
        String output = new _1071CommonDivisor().gcdOfStrings("LEET", "CODE");
        assertEquals("", output);
    }

    @Test
    public void test04(){
        String output = new _1071CommonDivisor().gcdOfStrings("ABCDEF", "ABC");
        assertEquals("", output);
    }

    @Test
    public void test14(){
        String output = new _1071CommonDivisor().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX");
        assertEquals("TAUXX", output);
    }

    @Test
    public void test119(){
        String output = new _1071CommonDivisor().gcdOfStrings("AAAAAAAAA", "AAACCC");
        assertEquals("", output);
    }
}
