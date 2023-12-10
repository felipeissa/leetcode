package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class _867TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int innerSize = matrix[0].length;
        int[][] transposed = new int[innerSize][matrix.length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < innerSize; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    @Test
    public void caseOne() {
        int[][] output = new _867TransposeMatrix().transpose(new int[][]{ new int[] {1, 2, 3}, new int[] {4,5,6}, new int[] {7,8,9}});
        int[][] expected = new int[][] {new int[] {1, 4, 7}, new int[] {2, 5 , 8}, new int[] {3 , 6 , 9}};

        assertArrayEquals(output, expected);
    }

    @Test
    public void caseTwo() {
        int[][] output = new _867TransposeMatrix().transpose(new int[][]{ new int[] {1, 2, 3}, new int[] {4,5,6}});
        int[][] expected = new int[][] {new int[] {1, 4 }, new int[] {2, 5 }, new int[] {3 , 6}};

        assertArrayEquals(output, expected);
    }
}
