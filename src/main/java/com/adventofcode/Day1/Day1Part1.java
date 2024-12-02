package com.adventofcode.Day1;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Samip Bikram Thapa
 * @Date: 12/2/24
 **/

public class Day1Part1 {
    private static final String inputFile = "day1.txt";
    Logger logger = LoggerFactory.getLogger(Day1Part1.class);

    public static void main(String[] args) throws IOException {
        Day1Part1 solution = new Day1Part1();
        solution.run();
    }

    void run() throws IOException {
        var lines = Resources.readLines(ClassLoader.getSystemResource(inputFile), Charsets.UTF_8);
        int result = totalDistance(lines);
        logger.info("Total distance between lists: {}", result);
    }

    int totalDistance(List<String> lines) {
        int[] leftList = new int[lines.size()];
        int[] rightList = new int[lines.size()];

        int i = 0;
        for (String line : lines) {
            String[] numbers = line.split("\\s+");
            leftList[i] = Integer.parseInt(numbers[0]);
            rightList[i] = Integer.parseInt(numbers[1]);
            i++;
        }

        Arrays.sort(leftList);
        Arrays.sort(rightList);

        int distance = 0;
        for (int j = 0; j < lines.size(); j++) {
            distance += Math.abs(rightList[j] - leftList[j]);
        }
        return distance;
    }
}
