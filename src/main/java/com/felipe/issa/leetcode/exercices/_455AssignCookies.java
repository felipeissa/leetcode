package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class _455AssignCookies {

    public int findContentChildren(int[] greedFactors, int[] cookieSizes) {
        int cookies = 0;

        Arrays.sort(cookieSizes);
        Arrays.sort(greedFactors);

        int cookieIndex = 0;
        int greedyIndex = 0;

        while(cookieIndex < cookieSizes.length && greedyIndex < greedFactors.length) {
            while(cookieIndex < cookieSizes.length && greedFactors[greedyIndex] > cookieSizes[cookieIndex]) cookieIndex++;

            if(cookieIndex < cookieSizes.length) {
                cookies++;
                cookieIndex = cookieIndex +1;
            }

            greedyIndex++;
        }

        return cookies;
    }

    public int findContentChildrenBruteForce(int[] greedFactors, int[] cookieSizes) {
        int cookies = 0;

        Arrays.sort(greedFactors);
        Arrays.sort(cookieSizes);

        for(int i = greedFactors.length -1; i >= 0; i--) {
            for(int j = cookieSizes.length -1; j >= 0; j-- ) {
                if(cookieSizes[j] >= greedFactors[i]) {
                    cookies++;
                    cookieSizes[j] = -1;
                    break;
                }
            }
        }

        return cookies;
    }
    @Test
    public void firstCase() {
        int output = new _455AssignCookies().findContentChildren(ArrayParser.parse("[1,2,3]"), ArrayParser.parse("[1,1]"));
        assertEquals(1, output);
    }

    @Test
    public void secondCase() {
        int output = new _455AssignCookies().findContentChildren(ArrayParser.parse("[1,2]"), ArrayParser.parse("[1,2,3]"));
        assertEquals(2, output);
    }
}
