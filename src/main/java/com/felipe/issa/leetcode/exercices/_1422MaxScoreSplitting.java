package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class _1422MaxScoreSplitting {

    public int maxScore(String s) {
        int possibleOnes = 0;
        int zeros = 0;
        int size = s.length();
        for(int i = 0; i < size; i++) {
            if(s.charAt(i) == '1') possibleOnes++;
        }

        int maxValue = 0;
        for(int i = 0; i < size -1 ; i++) {
            if(s.charAt(i) == '1') possibleOnes--;
            else zeros ++;
            maxValue = Math.max(maxValue, zeros + possibleOnes);
        }

        return maxValue;
    }

    @Test
    public void firstCase() {
        int output = new _1422MaxScoreSplitting().maxScore("011101");
        assertEquals(5, output);
    }

    @Test
    public void secondCase() {
        int output = new _1422MaxScoreSplitting().maxScore("00111");
        assertEquals(5, output);
    }

    @Test
    public void thirdCase() {
        int output = new _1422MaxScoreSplitting().maxScore("1111");
        assertEquals(3, output);
    }

    @Test
    public void test97() {
        int output = new _1422MaxScoreSplitting().maxScore("0100");
        assertEquals(2, output);
    }
}
