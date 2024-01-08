package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class _2610ArrayInto2DArray {

    public List<List<Integer>> findMatrix(int[] nums) {
        int[] db = new int[nums.length + 1];

        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int index = db[nums[i]];
            if(output.size() <= index) {
                output.add(new ArrayList<>());
            }
            output.get(index).add(nums[i]);
            db[nums[i]]++;
        }
        return output;
    }

    @Test
    public void firstCase() {
        List<List<Integer>> output = new _2610ArrayInto2DArray().findMatrix(ArrayParser.parse("[1,3,4,1,2,3,1]"));
        assertEquals(Arrays.asList(Arrays.asList(1, 3, 4, 2), Arrays.asList(1,3), Arrays.asList(1)), output);
    }
}
