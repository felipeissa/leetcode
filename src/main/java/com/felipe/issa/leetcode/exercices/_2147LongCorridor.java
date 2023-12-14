package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void firstCase() {
        int output = new _2147LongCorridor().numberOfWays("SSPS");;
        assertEquals(0, output);
    }
    @Test
    public void secondCase() {
        int output = new _2147LongCorridor().numberOfWays("PPSPSP");
        assertEquals(1, output);
    }
    @Test
    public void thirdCase() {
        int output = new _2147LongCorridor().numberOfWays("SSPPSPS");;
        assertEquals(3, output);
    }

    @Test
    public void forthCase() {
        int output = new _2147LongCorridor().numberOfWays("SPPSSSSPPS");
        assertEquals(1, output);
    }

    @Test
    public void fifthCase() {
        int output = new _2147LongCorridor().numberOfWays("P");
        assertEquals(0, output);
    }

    @Test
    public void sixthCase() {
        int output = new _2147LongCorridor().numberOfWays("PPPPPSPPSPPSPPPSPPPPSPPPPSPPPPSPPSPPPSPSPPPSPSPPPSPSPPPSPSPPPPSPPPPSPPPSPPSPPPPSPSPPPPSPSPPPPSPSPPPSPPSPPPPSPSPSS");
        assertEquals(919999993, output);
    }
}
