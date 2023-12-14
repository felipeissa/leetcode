package com.felipe.issa.leetcode.shared;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayParser {

    public static int[] parse(String value) {
        if(value.isEmpty() || value.length() == 2) return new int[] { };
        String[] originalValues = value.substring(1, value.length() - 1).split(",");

        int[] values = new int[originalValues.length];

        for(int i = 0; i < originalValues.length; i++) {
            values[i] = Integer.parseInt(originalValues[i]);
        }

        return values;
    }

    @Test
    public void arrayWithValues() {
        int[] array = ArrayParser.parse("[1,2,3,4,5,6]");

        assertArrayEquals(new int[]{ 1, 2, 3, 4, 5, 6}, array);
    }

    @Test
    public void arrayWithSingleValue() {
        int[] array = ArrayParser.parse("[1]");

        assertArrayEquals(new int[]{ 1 }, array);
    }

    @Test
    public void emptyArray() {
        int[] array = ArrayParser.parse("[]");

        assertArrayEquals(new int[]{ }, array);
    }

    @Test
    public void emptyString() {
        int[] array = ArrayParser.parse("");

        assertArrayEquals(new int[]{ }, array);
    }
}
