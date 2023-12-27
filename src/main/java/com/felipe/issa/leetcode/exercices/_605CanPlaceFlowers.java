package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _605CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0)
            && (i+1 == flowerbed.length || flowerbed[i+1] == 0))
            {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }

    @Test
    public void firstCase() {
        boolean output = new _605CanPlaceFlowers().canPlaceFlowers(ArrayParser.parse("[1,0,0,0,1]"), 1);
        assertEquals(true, output);
    }

    @Test
    public void secondCase() {
        boolean output = new _605CanPlaceFlowers().canPlaceFlowers(ArrayParser.parse("[1,0,0,0,1]"), 2);
        assertEquals(false, output);
    }

    @Test
    public void test96() {
        boolean output = new _605CanPlaceFlowers().canPlaceFlowers(ArrayParser.parse("[1,0,0,0,0,1]"), 2);
        assertEquals(false, output);
    }
}
