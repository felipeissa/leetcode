package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;

public class _1622MinimumTimeVisiting {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        int currentX = points[0][0];
        int currentY = points[0][1];


        for(int i = 1; i < points.length; i++) {
            int nextX = points[i][0];
            int nextY = points[i][1];

            int maxDistance = Math.max(Math.abs(nextX - currentX), Math.abs(nextY - currentY));

            currentX = nextX;
            currentY = nextY;

            time += maxDistance;
        }


        return time;
    }

    public static void main(String[] args) {
        int output;
        int expected;

        output = new _1622MinimumTimeVisiting().minTimeToVisitAllPoints(new int[][]{ new int[]{1, 1}, new int[] {3, 4}, new int[]{-1, 0}});
        expected = 7;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", output == expected, expected, output));
    }
}
