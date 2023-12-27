package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.text.MessageFormat;

import static junit.framework.TestCase.assertEquals;

public class _11ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length -1;
        while(end > start) {
           int area = (end - start) * Math.min(height[end], height[start]);
           maxArea = Math.max(maxArea, area);
           if(height[end] < height[start]) end--;
           else start++;
        }

        return maxArea;
    }


    @Test
    public void firstCase(){
        int output = new _11ContainerWithMostWater().maxArea(ArrayParser.parse("[1,8,6,2,5,4,8,3,7]"));
        assertEquals(49, output);
    }

    @Test
    public void secondCase(){
        int output = new _11ContainerWithMostWater().maxArea(ArrayParser.parse("[1,1]"));
        assertEquals(1, output);
    }

    @Test
    public void test53(){
        int output = new _11ContainerWithMostWater().maxArea(ArrayParser.parse("[2,1]"));
        assertEquals(1, output);
    }

    @Test
    public void test24(){
        int output = new _11ContainerWithMostWater().maxArea(ArrayParser.parse("[1,2,1]"));
        assertEquals(2, output);
    }
}
