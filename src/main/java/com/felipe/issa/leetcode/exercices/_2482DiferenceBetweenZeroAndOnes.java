package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayOfArraysParser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class _2482DiferenceBetweenZeroAndOnes {
    public int[][] onesMinusZeros(int[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        int[][] response = new int[totalRows][totalColumns];
        Map<Integer, Integer> onesRow = new HashMap<>();
        Map<Integer, Integer> onesCol = new HashMap<>();
        Map<Integer, Integer> zerosRow = new HashMap<>();
        Map<Integer, Integer> zerosCol = new HashMap<>();

        for(int row = 0; row < totalRows; row++) {
            for(int col = 0; col < totalColumns; col++) {
                if(grid[row][col] == 1) {
                    onesRow.put(row, onesRow.getOrDefault(row, 0) + 1);
                    onesCol.put(col, onesCol.getOrDefault(col, 0) + 1);
                    continue;
                }
                zerosRow.put(row, zerosRow.getOrDefault(row, 0) + 1);
                zerosCol.put(col, zerosCol.getOrDefault(col, 0) + 1);
            }
        }

        for(int row = 0; row < totalRows; row++) {
            for(int col = 0; col < totalColumns; col++) {
                response[row][col] = onesRow.getOrDefault(row, 0) + onesCol.getOrDefault(col, 0)
                    - zerosRow.getOrDefault(row, 0) - zerosCol.getOrDefault(col, 0);
            }
        }

        return response;
    }


    @Test
    public void firstCase() {
        int[][] output = new _2482DiferenceBetweenZeroAndOnes().onesMinusZeros(ArrayOfArraysParser.parse("[[0,1,1],[1,0,1],[0,0,1]]"));
        int[][] expected = ArrayOfArraysParser.parse("[[0,0,4],[0,0,4],[-2,-2,2]]");

        assertEquals(expected.length, output.length);
        for(int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], output[i]);
        }
    }

    @Test
    public void secondCase() {
        int[][] output = new _2482DiferenceBetweenZeroAndOnes().onesMinusZeros(ArrayOfArraysParser.parse("[[1,1,1],[1,1,1]]"));
        int[][] expected = ArrayOfArraysParser.parse("[[5,5,5],[5,5,5]]");

        assertEquals(expected.length, output.length);
        for(int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], output[i]);
        }
    }

}
