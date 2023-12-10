package com.toastedrecords;

import com.toastedrecords.common.InputReader;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class Day4 {
    public static void main(String[] args) {
        List<String> input = InputReader.parseInput("day4");

        int i = 1, sum = 0;
        int[] cards = new int[input.size()+1];

        for (var line : input) {
            int matches = getMatches(line);
            int numCards = ++cards[i];
            sum += numCards;
            IntStream.rangeClosed(i+1, i+matches).forEach(j -> cards[j] += numCards);
            i++;
        }

        System.out.println(sum);
    }

    private static int getMatches(String line) {
        String[] allNums = line.substring(line.indexOf(':')+2).trim().split(" \\| ");
        var winningNums = Arrays.stream(allNums[0].split("\\s+")).collect(toSet());
        var nums = Arrays.stream(allNums[1].split("\\s+")).collect(toSet());
        winningNums.retainAll(nums);
        return winningNums.size();
    }

//    private static Result<Integer> getSets(String line) {
//        Set<Integer> winners = new HashSet<>();
//        Set<Integer> played = new HashSet<>();
//
//        String[] split = line.split(":");
//        // Get the game number
//        String[] card = split[0].split(" ");
//        int cardNum = Integer.parseInt(card[1]);
//        String[] games = split[1].split("[|]");
//        for (var thing : games[0].split(" ")) {
//            if(!thing.isEmpty()) {
//                winners.add(Integer.parseInt(thing));
//            }
//        }
//
//        for (var thing : games[1].split(" ")) {
//            if (!thing.isEmpty()) {
//                played.add(Integer.parseInt(thing));
//            }
//        }
//
//        return new Result<>(cardNum, winners, played);
//    }
}
