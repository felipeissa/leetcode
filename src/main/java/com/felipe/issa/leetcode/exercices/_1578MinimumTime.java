package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.text.MessageFormat;

import static junit.framework.TestCase.assertEquals;

public class _1578MinimumTime {
    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        int previousItem = 0;
        for(int i = 1; i < colors.length(); i++) {
            if(colors.charAt(previousItem) == colors.charAt(i)) {
                int indexToRemove = neededTime[i] < neededTime[previousItem] ? i : previousItem;
                previousItem = indexToRemove == previousItem ? i : previousItem;
                time += neededTime[indexToRemove];
                continue;
            }

            previousItem = i;
        }

        return time;
    }


    @Test
    public void firstCase(){
        int output = new _1578MinimumTime().minCost("abaac", ArrayParser.parse("[1,2,3,4,5]"));
        assertEquals(3, output);
    }

    @Test
    public void secondCase(){
        int output = new _1578MinimumTime().minCost("abc", ArrayParser.parse("[1,2,3]"));
        assertEquals(0, output);
    }

    @Test
    public void thirdCase(){
        int output = new _1578MinimumTime().minCost("aabaa", ArrayParser.parse("[1,2,3,4,1]"));
        assertEquals(2, output);
    }

    @Test
    public void test32(){
        int output = new _1578MinimumTime().minCost("aaabbbabbbb", ArrayParser.parse("[3,5,10,7,5,3,5,5,4,8,1]"));
        assertEquals(26, output);
    }

    @Test
    public void test47(){
        int output = new _1578MinimumTime().minCost("acaaaacccc", ArrayParser.parse("[9,3,9,8,8,3,2,7,6,6]"));
        assertEquals(33, output);
    }
}
