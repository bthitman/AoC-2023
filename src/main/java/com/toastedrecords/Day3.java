package com.toastedrecords;

import com.toastedrecords.common.InputReader;

import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        List<String> input = InputReader.parseInput("day3");

        int rowCount = input.size();
        int colCount = input.get(0).length();

        char[][] grid = new char[rowCount][colCount];

        int a=0;
        for (var line : input) {
            int b=0;
            for (var c : line.toCharArray()) {
                grid [a][b] = c;
                b++;
            }
            a++;
        }

        int sum = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (!Character.isDigit(grid[i][j]) || grid[i][j] != '.') {
                    sum += findAndSumGears(grid, i, j);
                }
            }
        }
    }

    private static int findAndSumGears(char[][] grid, int i, int j) {
        // Check Left
        if (Character.isDigit(grid[i][j-1])) {
            // Keep looking

        }
    }
}
