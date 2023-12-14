package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class _1582SpecialPositionBinaryMatrix {

    public int numSpecial(int[][] mat) {
        int totalLines = mat.length;
        int totalColumn = mat[0].length;
        int specialPositions = 0;

        Map<Integer, Integer> lineOneColumn = new HashMap<>();
        Map<Integer, Integer> columnOneCount = new HashMap<>();

        for(int line = 0; line < totalLines; line++) {
            for(int column = 0; column < totalColumn; column++) {
                if(mat[line][column] == 1) {
                    columnOneCount.put(column, columnOneCount.getOrDefault(column, 0) + 1);
                    if(lineOneColumn.containsKey(line)) {
                        lineOneColumn.put(line, -1);
                        continue;
                    }
                    lineOneColumn.put(line, column);

                }
            }
        }

        for(Map.Entry<Integer, Integer> lineCount: lineOneColumn.entrySet()) {
            if(lineCount.getValue() == -1) continue;
            if(columnOneCount.getOrDefault(lineOneColumn.get(lineCount.getKey()), 0) == 1) specialPositions ++;
        }

        return specialPositions;
    }


    @Test
    public void caseOne() {
        int output = new _1582SpecialPositionBinaryMatrix().numSpecial(new int[][] { new int[] {1,0 ,0}, new int[] {0 ,0, 1}, new int[] {1,0 ,0}, });
        assertEquals(1, output);
    }

    @Test
    public void caseTwo() {
        int output = new _1582SpecialPositionBinaryMatrix().numSpecial(new int[][] { new int[] {1,0,0}, new int[] {0,1,0}, new int[] {0,0,1}, });
        assertEquals(3, output);
    }

    @Test
    public void caseFortyFour() { //[[0,0,1,0],[0,0,0,0],[0,0,0,0],[0,1,0,0]]
        int output = new _1582SpecialPositionBinaryMatrix().numSpecial(new int[][] { new int[] {0,0,1,0}, new int[] {0,0,0,0}, new int[] {0,0,0,0}, new int[] { 0,1,0,0 } });
        assertEquals(2, output);
    }

    @Test
    public void caseFortyFive() { // [[0,0,0,0,0,0,0,0],[0,0,0,1,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,1,0],[0,1,0,0,0,0,1,0],[0,1,0,0,0,0,0,0]]
        int output = new _1582SpecialPositionBinaryMatrix().numSpecial(new int[][]{
                new int[]{0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 1, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 1, 0},
                new int[]{0, 1, 0, 0, 0, 0, 1, 0},
                new int[]{0, 1, 0, 0, 0, 0, 0, 0},
        });
        assertEquals(1, output);
    }
}
