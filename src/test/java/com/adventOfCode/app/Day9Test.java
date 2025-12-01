package com.adventOfCode.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.adventOfCode.app.day9.Day9;

public class Day9Test {

  @Test
  public void testRunLinesWithSampleInputPart1() {
    String[] lines = {
        "...",
        "..."
    };

    Result result = Day9.RunLines(lines);

    assertEquals(-1, result.part1);
  }

  @Test
  public void testRunLinesWithSampleInputPart2() {
    String[] lines = {
        "...",
        "..."
    };

    Result result = Day9.RunLines(lines);

    assertEquals(-1, result.part2);
  }

  @Test
  public void fullTest() {
    Result result = Day9.Run();

    assertEquals(-1, result.part1);
    assertEquals(-1, result.part2);
  }

}
