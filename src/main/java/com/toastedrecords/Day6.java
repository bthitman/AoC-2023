package com.toastedrecords;

import com.toastedrecords.common.InputReader;

import java.util.List;

public class Day6 {
    public static void main(String[] args) {
        List<String> input = InputReader.parseInput("day6");

        partOne(input);
        partTwo(input);
    }

    private static void partOne(List<String> input) {
        // Get the Time list
        var times = input.get(0).substring(input.get(0).indexOf(":")+1).trim().split("\\s+");
        var distances = input.get(1).substring(input.get(1).indexOf(":")+1).trim().split("\\s+");

        int[] winners = new int[times.length];
        int sum = 0;
        for (int i=0; i< times.length; i++) {
            var time = Integer.parseInt(times[i]);
            var dist = Integer.parseInt(distances[i]);
            for (int j=0; j<time; j++) {
                if (j * (time-j) > dist) {
                    ++winners[i];
                }
            }
        }
        sum = winners[0];
        for (int k=1; k<winners.length; k++) {
            sum = sum * winners[k];
        }
        System.out.println(sum);
    }

    private static void partTwo(List<String> input) {
        var time = Long.parseLong(input.get(0).substring(input.get(0).indexOf(":")+1).trim().replace(" ", ""));
        var dist = Long.parseLong(input.get(1).substring(input.get(1).indexOf(":")+1).trim().replace(" ", ""));

        int sum = 0;
        for (int i=0; i<time; i++) {
            if (i * (time-i) > dist) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
