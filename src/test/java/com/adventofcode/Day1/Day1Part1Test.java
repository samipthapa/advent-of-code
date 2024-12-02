package com.adventofcode.Day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class Day1Part1Test {
    private final Day1Part1 day1Part1 = new Day1Part1();

    @Test
    void totalDistance() throws IOException {
        var lines = List.of(
                "3 4",
                "4 3",
                "2 5",
                "1 3",
                "3 9",
                "3 3"
        );
        assertEquals(11, day1Part1.totalDistance(lines));
    }
}