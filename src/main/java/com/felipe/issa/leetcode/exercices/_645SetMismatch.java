package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.text.MessageFormat;

import static org.junit.Assert.assertArrayEquals;

public class _645SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] values = new int[nums.length +1];

        for(int i = 0; i < nums.length; i++) {
            values[nums[i]]++;
        }

        int duplicated = -1;
        int missing = -1;
        for(int i = 1; i < values.length; i++) {
            if(values[i] == 2) duplicated = i;
            if(values[i] == 0) missing = i;
            if(duplicated >= 0 && missing >= 0) {
                return new int[] { duplicated, missing };
            }
        }
        return null;
    }

    @Test
    public void firstCase() {
        int[] output = new _645SetMismatch().findErrorNums(ArrayParser.parse("[1,2,2,4]"));
        assertArrayEquals(ArrayParser.parse("[2,3]"), output);
    }

    @Test
    public void secondCase() {
        int[] output = new _645SetMismatch().findErrorNums(ArrayParser.parse("[1,1]"));
        assertArrayEquals(ArrayParser.parse("[1,2]"), output);
    }
}
