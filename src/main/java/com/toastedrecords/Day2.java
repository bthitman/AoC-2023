package com.toastedrecords;

import com.toastedrecords.common.InputReader;

import java.util.List;

public class Day2 {
    private static String BLUE = "blue";
    private static String RED = "red";
    private static String GREEN = "green";

    public static void main(String[] args) {
        int sum = partOne();
        System.out.println(sum);
        sum = partTwo();
        System.out.println(sum);
    }

    private static int partTwo() {
        var sum = 0;
        List<String> input = InputReader.parseInput("day2");
        for (var line : input) {
            int minRed = 0, minBlue = 0, minGreen = 0;
            String[] split = line.split(":");
            List<String> games = List.of(split[1].split(";"));
            for (var game : games) {
                String[] gameSplit = game.split(",");
                for (var blah : gameSplit) {
                    String[] g = blah.split(" ");
                    int num = 0;
                    if (g[2].contains(BLUE)) {
                        num = Integer.parseInt(g[1]);
                        if (num > minBlue) minBlue = num;
                    }
                    if (g[2].contains(RED)) {
                        num = Integer.parseInt(g[1]);
                        if (num > minRed) minRed = num;
                    }
                    if (g[2].contains(GREEN)) {
                        num = Integer.parseInt(g[1]);
                        if (num > minGreen) minGreen = num;
                    }
                }
            }
            sum += minBlue * minRed * minGreen;
        }

        return sum;
    }

    private static int partOne() {
        int maxRed = 12;
        int maxBlue = 14;
        int maxGreen = 13;

        List<String> input = InputReader.parseInput("day2");

        int sum = 0, gameNum = 0;
        boolean dodgy = false;

        for (var line : input) {
            String[] split = line.split(":");
            gameNum = Integer.parseInt(split[0].split(" ")[1]);
            List<String> games = List.of(split[1].split(";"));
            for (var game : games) {
                int redCount = 0, blueCount = 0, greenCount = 0;
                String[] gameSplit = game.split(",");
                for (var blah : gameSplit) {
                    String[] g = blah.split(" ");
                    if (g[2].contains(BLUE)) {
                        blueCount += Integer.parseInt(g[1]);
                    }
                    if (g[2].contains(RED)) {
                        redCount += Integer.parseInt(g[1]);
                    }
                    if (g[2].contains(GREEN)) {
                        greenCount += Integer.parseInt(g[1]);
                    }
                }

                if (blueCount > maxBlue || redCount > maxRed || greenCount > maxGreen) {
                    dodgy = true;
                    break;
                }
            }
            if (!dodgy) {
                sum += gameNum;
            } else {
                dodgy = false;
            }
        }
        return sum;
    }
}
