package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class _2147LongCorridor {

    final int MOD = 1_000_000_007;
    /**
     https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/?envType=daily-question&envId=2023-11-28
     */
    public int numberOfWays(String corridor) {
        int seats = 0;
        Integer previousLast = null;

        long ways = 1;
        int size = corridor.length();
        for(int i = 0; i < size; i++) {
            if(corridor.charAt(i) == 'S') {
                seats++;

                if(seats == 2) {
                    previousLast = i;
                    seats = 0;
                } else if (previousLast != null && seats == 1) {
                    ways *= (i - previousLast);
                    ways %= MOD;
                }

            }
        }

        if(seats == 1 || previousLast == null) return 0;
        return (int)ways;
    }

    public static void main(String[] args) {
        int output;
        int expected;
        output = new _2147LongCorridor().numberOfWays("SSPS");
        expected = 0;
        System.out.println(MessageFormat.format("Is same: {0}, Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _2147LongCorridor().numberOfWays("PPSPSP");
        expected = 1;
        System.out.println(MessageFormat.format("Is same: {0}, Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _2147LongCorridor().numberOfWays("SSPPSPS");
        expected = 3;
        System.out.println(MessageFormat.format("Is same: {0}, Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _2147LongCorridor().numberOfWays("SPPSSSSPPS");
        expected = 1;
        System.out.println(MessageFormat.format("Is same: {0}, Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _2147LongCorridor().numberOfWays("P");
        expected = 0;
        System.out.println(MessageFormat.format("Is same: {0}, Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _2147LongCorridor().numberOfWays("PPPPPSPPSPPSPPPSPPPPSPPPPSPPPPSPPSPPPSPSPPPSPSPPPSPSPPPSPSPPPPSPPPPSPPPSPPSPPPPSPSPPPPSPSPPPPSPSPPPSPPSPPPPSPSPSS");
        expected = 919999993;
        System.out.println(MessageFormat.format("Is same: {0}, Expected: {1}, got: {2}", output == expected, expected, output));
    }
}
