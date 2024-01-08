package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _1335MinimumDifficulty {

    int[][] db;
    int[] jobDifficulty;

    public int minDifficulty(int[] jobDifficulty, int remainingCuts) {
        if(remainingCuts > jobDifficulty.length) return -1;
        db = new int[jobDifficulty.length][remainingCuts +1];
        for(int[] array: db) Arrays.fill(array, -1);
        this.jobDifficulty = jobDifficulty;
        return solve(0, remainingCuts, 0, jobDifficulty[0]);
    }

    public int solve(int lastCut, int remainingCuts, int currentPosition, int maxSinceCut) {
        if(db[lastCut][remainingCuts] >= 0) {
            return db[lastCut][remainingCuts];
        }

        if(remainingCuts == 1 && lastCut+1 < jobDifficulty.length && db[lastCut+1][remainingCuts] >= 0) {
            db[lastCut][remainingCuts] = Math.max(jobDifficulty[currentPosition], db[lastCut+1][remainingCuts]);
            return db[lastCut][remainingCuts];
        }

        if(remainingCuts == 1 || jobDifficulty.length == currentPosition){
            int max = getMaxValue(lastCut, jobDifficulty.length);
            return max;
        }

        maxSinceCut = Math.max(maxSinceCut, jobDifficulty[currentPosition]);
        int maxCutting = solve(currentPosition + 1, remainingCuts -1, currentPosition +1, jobDifficulty[currentPosition +1]) ;

        if(currentPosition + remainingCuts >= jobDifficulty.length) {
            db[lastCut][remainingCuts] = maxCutting + maxSinceCut;
            return db[lastCut][remainingCuts];
        }
        int maxNoCut = solve(lastCut, remainingCuts, currentPosition +1, maxSinceCut);

        db[lastCut][remainingCuts] = Math.min(maxCutting + maxSinceCut, maxNoCut);
        return db[lastCut][remainingCuts];
    }

    public int getMaxValue(int lastCut, int end) {
        int max = 0;
        for(int i = lastCut; i < end; i++)
            max = Math.max(max, jobDifficulty[i]);
        return max;
    }

    @Test
    public void firstCase() {
        int output = new _1335MinimumDifficulty().minDifficulty(ArrayParser.parse("[6,5,4,3,2,1]"), 2);
        assertEquals(7, output);
    }

    @Test
    public void secondCase() {
        int output = new _1335MinimumDifficulty().minDifficulty(ArrayParser.parse("[9,9,9]"), 4);
        assertEquals(-1, output);
    }

    @Test
    public void thirdCase() {
        int output = new _1335MinimumDifficulty().minDifficulty(ArrayParser.parse("[1,1,1]"), 3);
        assertEquals(3, output);
    }

    @Test
    public void test10() {
        int output = new _1335MinimumDifficulty().minDifficulty(ArrayParser.parse("[7,1,7,1,7,1]"), 3);
        assertEquals(15, output);
    }

    @Test
    public void test33() {
        int output = new _1335MinimumDifficulty().minDifficulty(ArrayParser.parse("[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]"), 10);
        assertEquals(0, output);
    }
}
