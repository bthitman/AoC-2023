package com.toastedrecords;

import com.toastedrecords.common.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day1 {
    public static void main(String[] args) {
        List<String> input = InputReader.parseInput("day1");
        int sum=0;
        for (String line : input) {
            sum += parseDigits(line);
        }
        System.out.println(sum);
    }

    private static int parseDigits(String line) {
        String converted = convertStrings(line);
        List<Integer> digits = new ArrayList<>();
        for (Character c : converted.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(Integer.parseInt(c.toString()));
            }
        }
        int digit = digits.get(0) * 10 + digits.get(digits.size()-1);

        return digit;
    }

    private static String convertStrings(String line) {
        for (Map.Entry<String, String> entry : digitMap.entrySet()) {
            if (line.contains(entry.getKey())) {
                line = line.replace(entry.getKey(), entry.getValue());
            }
        }
        return line;
    }

    private static Map<String, String> digitMap = Map.of(
            "one", "o1e",
            "two", "t2o",
            "three", "t3e",
            "four", "f4r",
            "five", "f5e",
            "six", "s6x",
            "seven", "s7n",
            "eight", "e8t",
            "nine", "n9e"
    );
}

