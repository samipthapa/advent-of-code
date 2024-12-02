package com.adventofcode.Day1;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Samip Bikram Thapa
 * @Date: 12/2/24
 **/

public class Day1Part2 {
    private static final String inputFile = "day1.txt";
    Logger logger = LoggerFactory.getLogger(Day1Part2.class);

    public static void main(String[] args) throws IOException {
        Day1Part2 solution = new Day1Part2();
        solution.run();
    }

    void run() throws IOException {
        var lines = Resources.readLines(ClassLoader.getSystemResource(inputFile), Charsets.UTF_8);
        int result = similarityScore(lines);
        logger.info("Total similarity score between lists: {}", result);
    }

    int similarityScore(List<String> lines) {
        int[] leftSide = new int[lines.size()];
        Map<Integer, Integer> rightCount = new HashMap<>();

        for (int i=0; i<lines.size(); i++) {
            String[] numbers = lines.get(i).split("\\s+");
            leftSide[i] = Integer.parseInt(numbers[0]);
            rightCount.put(Integer.parseInt(numbers[1]),
                    rightCount.getOrDefault(Integer.parseInt(numbers[1]), 0) + 1);
        }

        Arrays.sort(leftSide);

        int score = 0;
        for (int i=0; i<lines.size(); i++) {
            score += leftSide[i] * rightCount.getOrDefault(leftSide[i], 0);
        }
        return score;
    }
}
