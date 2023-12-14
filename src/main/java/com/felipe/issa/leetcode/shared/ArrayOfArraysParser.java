package com.felipe.issa.leetcode.shared;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ArrayOfArraysParser {

    public static final String SEPARATOR = "]";

    public static int[][] parse(String value) {
        if(value.isEmpty() || value.length() == 2) return new int[][] {};
        value = value.substring(1, value.length() - 1);

        List<int[]> values = new ArrayList<>();

        int begin = 0;
        int index = value.indexOf(SEPARATOR);
        while(index != -1) {
            String currentArray = value.substring(begin, index+1);

            values.add(ArrayParser.parse(currentArray));

            begin = index + 2;
            index = value.indexOf(SEPARATOR, begin);
        }

        return values.toArray(new int[0][0]);
    }

    @Test
    public void emptyArray() {
        int[][] output = ArrayOfArraysParser.parse("[]");

        assertArrayEquals(new int[][]{}, output);
    }

    @Test
    public void emptyString() {
        int[][] output = ArrayOfArraysParser.parse("[]");

        assertArrayEquals(new int[][]{}, output);
    }

    @Test
    public void validArray() {
        int[][] output = ArrayOfArraysParser.parse("[[0,1,1],[1,0,1],[0,0,1]]");

        assertArrayEquals(new int[][]{ new int[]{0, 1, 1}, new int[]{1, 0, 1}, new int[]{0, 0, 1}}, output);
    }
}
