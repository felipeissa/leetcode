package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayOfArraysParser;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class _2225ZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        int max = 0;
        int[] lossCount = new int[100001];

        for(int[] matchResult: matches) {
            int winner = matchResult[0];
            int loser = matchResult[1];

            if(lossCount[winner] == 0) {
                lossCount[winner] = -1;
            }

            if(lossCount[loser] == -1) {
                lossCount[loser] = 1;
            } else {
                lossCount[loser]++;
            }
            max = Math.max(winner, Math.max(max, loser));
        }

        List<Integer> winners = new ArrayList<>(lossCount.length);
        List<Integer> losers1 = new ArrayList<>(lossCount.length);
        for(int i = 0; i <= max; i++) {
            if(lossCount[i] == -1)
                winners.add(i);
            if(lossCount[i] == 1) {
                losers1.add(i);
            }
        }

        return Arrays.asList(winners, losers1);
    }

    public List<List<Integer>> findWinnersMine(int[][] matches) {
        Set<Integer> winners = new TreeSet<>();
        Set<Integer> lostOne = new TreeSet<>();
        Set<Integer> knowTeam = new TreeSet<>();

        for(int[] matchResult: matches) {
            if(!knowTeam.contains(matchResult[0])) {
                winners.add(matchResult[0]);
            }

            if(lostOne.contains(matchResult[1])) {
                lostOne.remove(matchResult[1]);
            } else if(!knowTeam.contains(matchResult[1]) || winners.contains(matchResult[1])) {
                lostOne.add(matchResult[1]);
                winners.remove(matchResult[1]);
            }

            knowTeam.add(matchResult[0]);
            knowTeam.add(matchResult[1]);
        }

        return Arrays.asList(new ArrayList<>(winners), new ArrayList(lostOne));
    }

    @Test
    public void firstCase() {
        List output = new _2225ZeroOrOneLosses().findWinners(ArrayOfArraysParser.parse("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]"));
        assertEquals(Arrays.asList(1,2,10), output.get(0));
        assertEquals(Arrays.asList(4,5,7,8), output.get(1));
    }

    @Test
    public void secondCase() {
        List output = new _2225ZeroOrOneLosses().findWinners(ArrayOfArraysParser.parse("[[2,3],[1,3],[5,4],[6,4]]"));
        assertEquals(Arrays.asList(1,2,5,6), output.get(0));
        assertEquals(Arrays.asList(), output.get(1));
    }
}
