package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1622MinimumTimeVisiting {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        int currentX = points[0][0];
        int currentY = points[0][1];


        for (int i = 1; i < points.length; i++) {
            int nextX = points[i][0];
            int nextY = points[i][1];

            int maxDistance = Math.max(Math.abs(nextX - currentX), Math.abs(nextY - currentY));

            currentX = nextX;
            currentY = nextY;

            time += maxDistance;
        }


        return time;
    }

    @Test
    public void firstCase() {
        int output = new _1622MinimumTimeVisiting().minTimeToVisitAllPoints(new int[][]{new int[]{1, 1}, new int[]{3, 4}, new int[]{-1, 0}});
        assertEquals(7, output);
    }
}
