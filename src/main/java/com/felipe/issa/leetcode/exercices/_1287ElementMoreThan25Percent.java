package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class _1287ElementMoreThan25Percent {
    public int findSpecialInteger(int[] arr) {

        int maxCount = 0;
        int maxCountNumber = 0;
        int previousNumber = 0;
        int count = 0;

        for(Integer i: arr) {

            if(i != previousNumber) {
                if(count > maxCount) {
                    maxCount = count;
                    maxCountNumber = previousNumber;
                }
                previousNumber = i;
                count = 1;
            }

            count++;
        }

        if(count > maxCount) {
            maxCountNumber = previousNumber;
        }

        return maxCountNumber;
    }


    @Test
    public void caseOne() {
        int output = new _1287ElementMoreThan25Percent().findSpecialInteger(new int[] { 1,2,2,6,6,6,6,7,10 });
        assertEquals(6, output);
    }

    @Test
    public void caseTwo() {
        int output = new _1287ElementMoreThan25Percent().findSpecialInteger(new int[] { 1,1 });
        assertEquals(1, output);
    }
}
