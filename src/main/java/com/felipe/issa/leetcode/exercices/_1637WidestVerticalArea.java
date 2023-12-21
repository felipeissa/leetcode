package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayOfArraysParser;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class _1637WidestVerticalArea {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int maxWidth = 0;
        for(int i = 1; i < points.length; i++) {
            maxWidth = Math.max(maxWidth, (points[i][0] - points[i-1][0]));
        }

        return maxWidth;
    }

    public int maxWidthOfVerticalAreaDoubleArray(int[][] points) {
        int size = points.length;
        int[] xAxis = new int[size];
        for(int i = 0; i < size; i++) {
            xAxis[i] = points[i][0];
        }
        Arrays.sort(xAxis);

        int maxWidth = 0;
        int previous = xAxis[0];
        for(int value: xAxis) {
            maxWidth = Math.max(maxWidth, (value - previous));
            previous = value;
        }

        return maxWidth;
    }

    public int maxWidthOfVerticalAreaTreeSet(int[][] points) {
        NavigableSet<Integer> xAxis = new TreeSet<>();
        for(int[] value: points) {
            xAxis.add(value[0]);
        }

        int maxWidth = 0;
        int previous = xAxis.first();
        for(int value: xAxis) {
            maxWidth = Math.max(maxWidth, (value - previous));
            previous = value;
        }

        return maxWidth;
    }

    @Test
    public void firstCase() {
        int output = new _1637WidestVerticalArea().maxWidthOfVerticalArea(ArrayOfArraysParser.parse("[[8,7],[9,9],[7,4],[9,7]]"));

        assertEquals(1, output);
    }

    @Test
    public void secondCase() {
        int output = new _1637WidestVerticalArea().maxWidthOfVerticalArea(ArrayOfArraysParser.parse("[[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]"));

        assertEquals(3, output);
    }
}
