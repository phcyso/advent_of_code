package com.adventOfCode.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.adventOfCode.app.day2.Day2;

public class Day2Test {

  @Test
  public void testRunLinesWithSampleInput() {
    String[] lines = {
        "7 6 4 2 1",
        "1 2 7 8 9",
        "9 7 6 2 1",
        "1 3 2 4 5",
        "8 6 4 4 1",
        "1 3 6 7 9",
    };

    Result result = Day2.RunLines(lines);

    assertEquals(2, result.part1);
    assertEquals(4, result.part2);
  }

  @Test
  public void testRunLinesWithKnownBadInput() {
    String[] lines = {
        "4 6 7 9 11 12 12",
    };

    Result result = Day2.RunLines(lines);

    assertEquals(0, result.part1);
    assertEquals(1, result.part2);
  }
}
