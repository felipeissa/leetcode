package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayOfArraysParser;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _661ImageSmoother {

    int[][] directions = ArrayOfArraysParser.parse("[[-1,-1],[-1,0],[-1,+1],[0,-1],[0,0],[0,1],[1,-1],[1,0],[1,1]]");

    /**
     https://leetcode.com/problems/image-smoother/
     */


    public int[][] imageSmoother(int[][] img) {
        int rowLength = img.length;
        int columnLength = img[0].length;

        int[][] result = new int[rowLength][columnLength];

        for(int row = 0; row < rowLength; row++) {
            for(int column = 0; column < columnLength; column++) {
                int sum = 0;
                int count = 0;

                for(int[] possibilities: directions) {
                    int i = row + possibilities[0];
                    int j = column + possibilities[1];

                    if(i >= 0 && i < rowLength && j >= 0 && j < columnLength) {
                        sum += img[i][j];
                        count ++;
                    }
                }
                result[row][column] = sum / count;
            }
        }

        return result;
    }

    public int[][] imageSmootherBrute(int[][] img) {
        int rowLength = img.length;
        int columnLength = img[0].length;

        int[][] result = new int[rowLength][columnLength];

        for(int row = 0; row < rowLength; row++) {
            for(int column = 0; column < columnLength; column++) {
                boolean hasPreviousColumn = column -1 >= 0;
                boolean hasNextColumn = column +1 < columnLength;
                boolean hasPreviousRow = row -1 >= 0;
                boolean hasNextRow = row + 1 < rowLength;
                int sum = img[row][column];
                int count = 1;
                if(hasPreviousRow) {
                    sum+= img[row-1][column];
                    count++;
                    if(hasPreviousColumn) {
                        sum += img[row-1][column-1];
                        count++;
                    }
                    if(hasNextColumn) {
                        sum+= img[row-1][column+1];
                        count++;
                    }
                }
                if(hasPreviousColumn) {
                    sum += img[row][column-1];
                    count++;
                }

                if(hasNextColumn) {
                    sum += img[row][column+1];
                    count++;
                }
                if(hasNextRow) {
                    sum+= img[row+1][column];
                    count++;
                    if(hasPreviousColumn) {
                        sum += img[row+1][column-1];
                        count++;
                    }
                    if(hasNextColumn) {
                        sum+= img[row+1][column+1];
                        count++;
                    }
                }

                result[row][column] = sum / count;
            }
        }

        return result;
    }

    @Test
    public void firstCase() {
        int[][] output = new _661ImageSmoother().imageSmoother(ArrayOfArraysParser.parse("[[1,1,1],[1,0,1],[1,1,1]]"));
        int[][] expected = ArrayOfArraysParser.parse("[[0,0,0],[0,0,0],[0,0,0]]");

        for(int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], output[i]);
        }
    }

    @Test
    public void secondCase() {
        int[][] output = new _661ImageSmoother().imageSmoother(ArrayOfArraysParser.parse("[[100,200,100],[200,50,200],[100,200,100]]"));
        int[][] expected = ArrayOfArraysParser.parse("[[137,141,137],[141,138,141],[137,141,137]]");

        for(int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], output[i]);
        }
    }

    @Test
    public void caseTwo() {
        int[][] output = new _661ImageSmoother().imageSmoother(ArrayOfArraysParser.parse("[[2,3,4],[5,6,7],[8,9,10],[11,12,13],[14,15,16]]"));
        int[][] expected = ArrayOfArraysParser.parse("[[4,4,5],[5,6,6],[8,9,9],[11,12,12],[13,13,14]]");

        for(int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], output[i]);
        }
    }
}
