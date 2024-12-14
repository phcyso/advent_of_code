package com.adventOfCode.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.adventOfCode.app.day8.Day8;

public class Day8Test {

  @Test
  public void testRunLinesWithSampleInputPart1() {
    String[] lines = {
        "...",
        "..."
    };

    Result result = Day8.RunLines(lines);

    assertEquals(-1, result.part1);
  }

  @Test
  public void testRunLinesWithSampleInputPart2() {
    String[] lines = {
        "...",
        "..."
    };

    Result result = Day8.RunLines(lines);

    assertEquals(-1, result.part2);
  }

  @Test
  public void fullTest() {
    Result result = Day8.Run();

    assertEquals(-1, result.part1);
    assertEquals(-1, result.part2);
  }

}
