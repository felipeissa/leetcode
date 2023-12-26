package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class _1758MinimumChanges {

    public int minOperations(String s) {
        int start0 = 0;

        for(int i = 0; i < s.length(); i++) {
            if( i % 2 == 0 && s.charAt(i) == '1') {
                    start0 ++;
            } else if(s.charAt(i) == '0') {
                start0++;
            }
        }
        return Math.min(s.length() - start0, start0);
    }

    public int minOperationsDoubleCheck(String s) {
        int start0 = 0;
        int start1 = 0;

        for(int i = 0; i < s.length(); i++) {
            if( i % 2 == 0 ) {
                if(s.charAt(i) == '0') {
                    start1 ++;
                } else {
                    start0 ++;
                }
            } else {
                if(s.charAt(i) == '0') {
                    start0++;
                } else {
                    start1++;
                }
            }
        }
        return Math.min(start1, start0);
    }

    @Test
    public void firstCase() {
        int output = new _1758MinimumChanges().minOperations("0100");
        assertEquals(1, output);
    }
    @Test
    public void secondCase() {
        int output = new _1758MinimumChanges().minOperations("10");
        assertEquals(0, output);
    }

    @Test
    public void thirdCase() {
        int output = new _1758MinimumChanges().minOperations("1111");
        assertEquals(2, output);
    }

    @Test
    public void test64() {
        int output = new _1758MinimumChanges().minOperations("10010100");
        assertEquals(3, output);
    }
}
