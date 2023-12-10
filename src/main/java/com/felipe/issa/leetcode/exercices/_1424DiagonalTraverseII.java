package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class _1424DiagonalTraverseII {

    /**
     * https://leetcode.com/problems/diagonal-traverse-ii/
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> mapMaps = new HashMap<>();
        int count = 0;
        for (int i = nums.size() -1; i >= 0 ; i--) {
            List<Integer> currentRow = nums.get(i);
            for(int j = 0; j < currentRow.size(); j++) {
                int sum = i + j;
                List<Integer> sumMap = mapMaps.getOrDefault(sum, new ArrayList<Integer>());
                if(sumMap.isEmpty()) mapMaps.put(sum, sumMap);
                sumMap.add(currentRow.get(j));
                count++;
            }
        }

        int[] values = new int[count];
        count = 0;
        int sum = 0;
        while(mapMaps.containsKey(sum)) {

            List<Integer> sumMap = mapMaps.get(sum);
            for(Integer value: sumMap) {
                values[count++] = value;
            }

            sum++;
        }

        return values;
    }

    public int[] findDiagonalOrderBetterApproach(List<List<Integer>> nums) {
        Map<Integer, Map<Integer, Integer>> mapMaps = new HashMap<>();
        int biggestSum = 0;
        int count = 0;
        for (int i = 0; i <  nums.size(); i++) {
            List<Integer> currentRow = nums.get(i);
            for(int j = 0; j < currentRow.size(); j++) {
                int sum = i + j;
                biggestSum = Math.max(biggestSum, sum);
                Map<Integer, Integer> sumMap = mapMaps.getOrDefault(sum, new HashMap<>());
                sumMap.put(i, currentRow.get(j));
                mapMaps.put(sum, sumMap);
                count++;
            }
        }

        int[] values = new int[count];
        int index = 0;
        for(int j = 0; j <= biggestSum; j++) {
            Map<Integer, Integer> currentSum = mapMaps.getOrDefault(j, Collections.emptyMap());
            List<Integer> sortedRows = currentSum.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            for(Integer rowIndex: sortedRows) {
                values[index++] = currentSum.get(rowIndex);
            }
        }

        return values;
    }

    public int[] findDiagonalOrderBruteForce(List<List<Integer>> nums) {
        int totalCount = 0;
        for(List <Integer> line: nums) {
            totalCount += line.size();
        }

        int[] values = new int[totalCount];
        int index = 0;
        int i = 0, j = 0, line = i, column = j, size = nums.size();

        while(index < totalCount) {
            if(nums.get(line).size() > column) {
                values[index++] = nums.get(line).get(column);
            }

            if(line > 0) {
                line--;
                column++;
            } else if(i < size -1) {
                i++;
                column = j = 0;
                line = i;
            } else {
                line = i;
                column = ++j;
            }
        }

        return values;
    }

    public static void main(String[] args) {
        int[] output = new _1424DiagonalTraverseII().findDiagonalOrder(Arrays.asList(
            Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)
        ));
        System.out.println(MessageFormat.format("Output is: {0}. Expected: {1}. Same: {2}",
            Arrays.toString(output), "[1,4,2,7,5,3,8,6,9]", Arrays.equals(output, new int[]{ 1,4,2,7,5,3,8,6,9 })));

        output = new _1424DiagonalTraverseII().findDiagonalOrder(Arrays.asList(
            Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7), Arrays.asList(8), Arrays.asList(9, 10, 11), Arrays.asList(12, 13, 14, 15, 16)
        ));
        System.out.println(MessageFormat.format("Output is: {0}. Expected: {1}. Same: {2}",
            Arrays.toString(output), "[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]", Arrays.equals(output, new int[]{ 1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16 })));

        output = new _1424DiagonalTraverseII().findDiagonalOrder(Arrays.asList(
            Arrays.asList(14,12,19,16,9), Arrays.asList(13,14,15,8,11), Arrays.asList(11,13,1)
        ));
        System.out.println(MessageFormat.format("Output is: {0}. Expected: {1}. Same: {2}",
            Arrays.toString(output), "[14,13,12,11,14,19,13,15,16,1,8,9,11]", Arrays.equals(output, new int[]{ 14,13,12,11,14,19,13,15,16,1,8,9,11 })));
    }

}
