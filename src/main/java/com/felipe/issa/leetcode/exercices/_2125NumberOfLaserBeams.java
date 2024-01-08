package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _2125NumberOfLaserBeams {

    public int numberOfBeams(String[] bank) {

        int beans = 0;
        int lastRowCount = 0;
        for(String row: bank) {
            int rowCount = getNumberOfDevices(row);
            if(rowCount > 0) {
                beans += rowCount * lastRowCount;
                lastRowCount = rowCount;
            }
        }

        return beans;
    }

    private int getNumberOfDevices(String row) {
        int count = 0;
        for(int i = 0; i < row.length(); i++) {
            if(row.charAt(i) == '1') count++;
        }
        return count;
    }

    @Test
    public void firstCase() {
        int output = new _2125NumberOfLaserBeams().numberOfBeams(new String[] { "011001","000000","010100","001000" });
        assertEquals(8, output);
    }

    @Test
    public void secondCase() {
        int output = new _2125NumberOfLaserBeams().numberOfBeams(new String[] { "000","111","000" });
        assertEquals(0, output);
    }
}
