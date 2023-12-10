package com.toastedrecords;

import com.toastedrecords.common.InputReader;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3 {
    public static void main(String[] args) {
        List<String> input = InputReader.parseInput("day3");
        Map<Pair<Integer, Integer>, List<Integer>> chars = new HashMap<>();

        createCharMap(input, chars);
        char[][] grid = getFullGrid(input);

        int sum = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (!Character.isDigit(grid[i][j]) && grid[i][j] != '.') {
//                    sum += findAndSumGears(grid, i, j);
                }
            }
        }
    }



    private static char[][] getFullGrid(List<String> input) {
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
        return grid;
    }

    private static void createCharMap(List<String> input, Map<Pair<Integer, Integer>, List<Integer>> chars) {
        int r=0;
        for (var line : input) {
            int c=0;
            for (var item : line.toCharArray()) {
                if (!Character.isDigit(item) && item != '.') {
                    chars.put(Pair.of(r, c), new ArrayList<>());
                }
                c++;
            }
            r++;
        }
    }
}
